"use strict";
(function() {
    window.App = window.App || {};

    /*!
        query-string
        Parse and stringify URL query strings
        https://github.com/sindresorhus/query-string
        by Sindre Sorhus
        MIT License
    */
    App.queryString = {
        parse: function(str) {
            if (typeof str !== "string") {
                return {};
            }

            str = str.trim().replace(/^\?/, "");

            if (!str) {
                return {};
            }

            return str.trim().split("&").reduce(function(ret, param) {
                var parts = param.replace(/\+/g, " ").split("=");
                var key = parts[0];
                var val = parts[1];

                key = decodeURIComponent(key);
                // missing `=` should be `null`:
                // http://w3.org/TR/2012/WD-url-20120524/#collect-url-parameters
                val = val === undefined ? null : decodeURIComponent(val);

                if (!ret.hasOwnProperty(key)) {
                    ret[key] = val;
                } else if (Array.isArray(ret[key])) {
                    ret[key].push(val);
                } else {
                    ret[key] = [ret[key], val];
                }

                return ret;
            }, {});
        },

        stringify: function(obj) {
            return obj ? Object.keys(obj).map(function(key) {
                var val = obj[key];

                if (Array.isArray(val)) {
                    return val.map(function(val2) {
                        return encodeURIComponent(key) + "=" + encodeURIComponent(val2);
                    }).join("&");
                }

                return encodeURIComponent(key) + "=" + encodeURIComponent(val);
            }).join("&") : "";
        },

        push: function(key, new_value) {
            var params = this.parse(location.search);
            params[key] = new_value;
            var new_params_string = this.stringify(params);
            history.pushState({}, "", window.location.pathname + "?" + new_params_string);
        }
    };

    App.Local = {
        addParametros: function (chave, valor) {
            App.queryString.push(chave, valor);
        },

        getParametro: function(chave) {
            return App.queryString.parse(location.search)[chave];
        }
    };
})();