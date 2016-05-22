(function () {
    window.App = window.App || {};
    
    App.Mensagem = {
        informativa: function(mensagem) {
            this.apresentarMensagem(mensagem, "alert-info");
        },

        erro: function (mensagem) {
            this.apresentarMensagem(mensagem, "alert-danger");
        },

        sucesso: function (mensagem) {
            this.apresentarMensagem(mensagem, "alert-success");
        },

        aviso: function (mensagem) {
            this.apresentarMensagem(mensagem, "alert-warning");
        },
        
        apresentarMensagem: function(mensagem, tipo) {
            $("body .page-header").after(
                $("<div>").addClass("alert")
                            .addClass(tipo)
                            .prepend(mensagem));
        }
    };
})();