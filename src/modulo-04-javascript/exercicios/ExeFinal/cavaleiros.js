'use strict';
(function() {
    window.App = window.App || {};
    
    App.ListaDeCavaleiros = {
        goldSaints: new Array(), 
        
        iniciar: function() {
            this.atualizarLista();
            this.criarListaDeCavaleiros();
            this.buscarElementos();
            this.vincularEventos();
        },
        
        buscarElementos() {
            this.$listaDeCavaleiros = $(".lista-de-cavaleiros");
        },
        
        carregarCavaleiros: function() {
            this.goldSaints = JSON.parse('[{"id":1,"nome":"Mu","dataNascimento":"1967-03-27T03:00:00.000Z","alturaCm":182,"pesoLb":165.35,"signo":"\u00c1ries","tipoSanguineo":"A","localNascimento":"Tibete","localTreinamento":"Jamiel","golpes":["Parede de Cristal","Extin\u00e7\u00e3o Estelar","Revolu\u00e7\u00e3o Estelar"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14900361\/93eed452-0d66-11e6-8ba2-e083b8297b2b.png","isThumb":true}]},{"id":2,"nome":"Aldebaran","dataNascimento":"1967-05-08T03:00:00.000Z","alturaCm":210,"pesoLb":286.600941,"signo":"Touro","tipoSanguineo":"B","localNascimento":"Brasil","localTreinamento":"Brasil","golpes":["Grande Chifre"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14900419\/dca83616-0d66-11e6-9757-8d07311e6999.png","isThumb":true}]},{"id":3,"nome":"Saga","dataNascimento":"1959-05-30T03:00:00.000Z","alturaCm":188,"pesoLb":191.81,"signo":"G\u00eameos","tipoSanguineo":"AB","localNascimento":"Gr\u00e9cia","localTreinamento":"Santu\u00e1rio, Gr\u00e9cia","golpes":["Sat\u00e3 Imperial","Outra Dimens\u00e3o","Explos\u00e3o Gal\u00e1ctica"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14900456\/00e25b7e-0d67-11e6-9fb3-4b35577080d2.png","isThumb":true}]},{"id":4,"nome":"M\u00e1scara da Morte","dataNascimento":"1964-06-24T03:00:00.000Z","alturaCm":184,"pesoLb":180.77900,"signo":"C\u00e2ncer","tipoSanguineo":"A","localNascimento":"It\u00e1lia","localTreinamento":"Sic\u00edlia, It\u00e1lia","golpes":["Ondas do Inferno"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14900489\/2cc0fd40-0d67-11e6-9bc0-600c5381c650.png","isThumb":true}]},{"id":5,"nome":"Aiolia","dataNascimento":"1967-08-16T03:00:00.000Z","alturaCm":185,"pesoLb":187.392923,"signo":"Le\u00e3o","tipoSanguineo":"O","localNascimento":"Gr\u00e9cia","localTreinamento":"Santu\u00e1rio, Gr\u00e9cia","golpes":["C\u00e1psula do Poder","Pata do Le\u00e3o","Rel\u00e2mpago de Plasma"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14900613\/c4ba42f0-0d67-11e6-9c0e-e79c2278ab0b.png","isThumb":true}]},{"id":6,"nome":"Shaka","dataNascimento":"1967-09-19T03:00:00.000Z","alturaCm":182,"pesoLb":149.914338,"signo":"Virgem","tipoSanguineo":"AB","localNascimento":"\u00cdndia","localTreinamento":"Ganges, \u00cdndia","golpes":["Rendi\u00e7\u00e3o Divina","Ciclo das 6 Exist\u00eancias","Tesouro do C\u00e9u","Invoca\u00e7\u00e3o dos Esp\u00edritos","Ohm!","Kahn!"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14900695\/4a5675dc-0d68-11e6-8396-2a775a2b0c39.png","isThumb":true}]},{"id":7,"nome":"Dohko","dataNascimento":"1726-10-20T03:00:00.000Z","alturaCm":170,"signo":"Libra","tipoSanguineo":"A","localNascimento":"China","localTreinamento":"5 Picos Antigos de Rozan, China","golpes":["C\u00f3lera do Drag\u00e3o","C\u00f3lera dos 100 Drag\u00f5es"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14900848\/ea27d2e0-0d68-11e6-9d73-78add86a1811.png","isThumb":true}]},{"id":8,"nome":"Milo","dataNascimento":"1967-11-08T03:00:00.000Z","alturaCm":185,"pesoLb":185.1883,"signo":"Escorpi\u00e3o","tipoSanguineo":"B","localNascimento":"Gr\u00e9cia","localTreinamento":"Ilha de Milos, Gr\u00e9cia","golpes":["Restri\u00e7\u00e3o","Agulha Escarlate","Antares"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14900894\/36445900-0d69-11e6-81c9-77cb17448b9d.png","isThumb":true}]},{"id":9,"nome":"Aiolos","dataNascimento":"1960-11-30T03:00:00.000Z","alturaCm":187,"pesoLb":187.392923,"signo":"Sagit\u00e1rio","tipoSanguineo":"O","localNascimento":"Gr\u00e9cia","localTreinamento":"Santu\u00e1rio, Gr\u00e9cia","golpes":["Trov\u00e3o At\u00f4mico","Flecha da Justi\u00e7a"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14901061\/e5fe3b90-0d69-11e6-9a78-2449055be1fa.png","isThumb":true}]},{"id":10,"nome":"Shura","dataNascimento":"1964-01-12T03:00:00.000Z","alturaCm":186,"pesoLb":182.983678,"signo":"Capric\u00f3rnio","tipoSanguineo":"B","localNascimento":"Espanha","localTreinamento":"Montes Pirineus, Espanha","golpes":["Excalibur"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14901144\/5af186c8-0d6a-11e6-934a-35db18b16752.png","isThumb":true}]},{"id":11,"nome":"Camus","dataNascimento":"1967-02-07T03:00:00.000Z","alturaCm":184,"pesoLb":167.551319,"signo":"Aqu\u00e1rio","tipoSanguineo":"A","localNascimento":"Fran\u00e7a","localTreinamento":"Sib\u00e9ria Oriental","golpes":["P\u00f3 de Diamante","Trov\u00e3o Aurora","Execu\u00e7\u00e3o Aurora"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14901196\/9f128f78-0d6a-11e6-86b3-1a68234e9bfc.png","isThumb":true}]},{"id":12,"nome":"Afrodite","dataNascimento":"1965-03-10T03:00:00.000Z","alturaCm":183,"pesoLb":158.732829,"signo":"Peixes","tipoSanguineo":"O","localNascimento":"Su\u00e9cia","localTreinamento":"Groel\u00e2ndia","golpes":["Rosas Diab\u00f3licas Reais","Rosas Piranhas","Rosa Branca"],"imagens":[{"url":"https:\/\/cloud.githubusercontent.com\/assets\/526075\/14901259\/f4a0b3ca-0d6a-11e6-89b1-59855cabc43d.png","isThumb":true}]}]');
            
            localStorage["cavaleiros"] = JSON.stringify(this.goldSaints);
        },
        
        criarListaDeCavaleiros: function() {
            var self = this;
            var $listaDeImagens = $("<div>").addClass("lista-de-cavaleiros").addClass("row");
            $("body > .container").append($listaDeImagens);
            
            this.buscarElementos();
            
            this.goldSaints.forEach(function(cavaleiro) {
                self.criarDivCavaleiro(cavaleiro);
            });
        },
        
        vincularEventos: function() {
            var self = this;
            
            this.$listaDeCavaleiros.find("[deletar-cavaleiro]").click(function(e) {
                if(confirm("Voce deseja realmente deletar esse cavaleiro?")) {
                    self.deletarCavaleiro($(this).parent().data("id-cavaleiro"));
                    $(this).parents().find("[data-id-cavaleiro=" + $(this).parent().data("id-cavaleiro") + "]").remove();
                }                
                return e.preventDefault();
            })
        },
        
        addCavaleiro: function (cavaleiro) {
            this.atualizarLista();
            
            this.criarDivCavaleiro(cavaleiro);
        },
        
        deletarCavaleiro: function(idCavaleiro) {
            localStorage["cavaleiros"] = JSON.stringify(this.goldSaints.filter(function(cavaleiro) {
                return cavaleiro.id !== idCavaleiro;
            }))
        },
        
        atualizarLista: function () {
            if(localStorage["cavaleiros"] === undefined)
                this.carregarCavaleiros();
            else
                this.goldSaints = JSON.parse(localStorage["cavaleiros"]);
                
            console.log(this.goldSaints);
        },
        
        criarDivCavaleiro: function(cavaleiro) {        
            var self = this;                        
            cavaleiro.imagens.forEach(function(imagem, i) {
                self.$listaDeCavaleiros.append($("<div>").attr("data-id-cavaleiro", cavaleiro.id)
                                                            .addClass("col-sm-2")
                                                            .addClass("cavaleiro")
                                                            .prepend($("<a>").addClass("glyphicon")
                                                                            .addClass("glyphicon-remove")
                                                                            .attr("deletar-cavaleiro", "")
                                                                            .attr("href", ""))
                                                            .append($("<img>").attr("alt", cavaleiro.nome)
                                                                    .attr("src", imagem.url).addClass("img-thumbnail"))                                                            
                                                )
            });                  
        },
        
        getCavaleiroPorId: function(idCavaleiro) {
            return this.goldSaints.filter(function(cavaleiro) {
                return cavaleiro.id === idCavaleiro;
            })
        }
    };
    
    App.CadastroDeCavaleiros = {
        iniciar: function() {
            this.buscarElementos();
            this.vincularEventos();
        },
        
        buscarElementos:  function() {
            this.$form = $(".cadastro-de-cavaleiros");
        },
        
        vincularEventos:  function() {
            var self = this;
            this.$form.submit(function(e) {
                e.preventDefault(); // remover isso
                
                self.cadastrarCavaleiro($(this));
                self.clearForm();
                return e.preventDefault();
            });
            
            this.$form.find(".add-golpe").click(function(e) {
                $(".golpes").prepend(
                    $("<div>").addClass("col-sm-4")
                                .prepend(
                                    $("<input>").attr("type", "text")
                                                    .addClass("form-control")
                                                    .attr("name", "golpes[]")
                                )
                );
                return e.preventDefault();
            });
            
            this.$form.find(".add-imagem").click(function(e) {
                var $inputText = $("<div>").addClass("col-sm-8");
                var $inputCheck = $("<div>").addClass("col-sm-4");
                $inputText.prepend(
                    $("<input>").attr("type", "text")
                                    .addClass("form-control")
                                    .attr("name", "urls[]")
                );
                
                $inputCheck.prepend(
                    $("<label>").prepend("É thumbnail?").prepend(
                            $("<input>").attr("type", "checkbox").attr("name", "isThumb[]")
                    )
                );
                
                $(".imagens").prepend($("<div>")
                                .addClass("imagem")
                                .addClass("col-sm-6")
                                .prepend($inputCheck)
                                .prepend($inputText)
                );              
                return e.preventDefault();
            });
            
            this.$form.find("#dataNascimento").datepicker({
                format: "dd/mm/yyyy"
            });
        },
        
        cadastrarCavaleiro: function($cavaleiro) {
            var cavaleiros = JSON.parse(localStorage["cavaleiros"]);
            var cavaleiro = App.Converte.doFormParaUmCavaleiro($cavaleiro);
            if(!this.cavaleiroNoPadrao(cavaleiro))
                return;
            cavaleiros.push(cavaleiro);
            
            localStorage["cavaleiros"] = JSON.stringify(cavaleiros);
            
            App.ListaDeCavaleiros.addCavaleiro(cavaleiro);
        },
        
        clearForm: function() {
            this.$form[0].reset();
        },
        
        cavaleiroNoPadrao: function(cavaleiro) {
            if(cavaleiro.alturaCm < 0) {
                App.Mensagem.erro("Você não pode adicionar uma altura negativa");
                return false;
            }
            
            if(cavaleiro.pesoLb < 0) {
                App.Mensagem.erro("Você não pode adicionar um peso negativo");
                return false;
            }
            
            return true;
        }
    };
    
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
            $("body > .container > .page-header").after(
                $("<div>").addClass("alert")
                            .addClass(tipo)
                            .prepend(mensagem));
        }
    };
    
    App.Converte = {
        deDataBrParaPadraoISO: function(data) {
            var dia = data.substr(0, 2), mes = data.substr(3, 2), ano = data.substr(6, 4);
            return new Date(Date.parse(mes + "/" + dia + "/" + ano)).toISOString();
        },
        
        deMetrosParaCentimetros: function(altura) {
            return parseFloat(altura) * 100;
        },
        
        deKgParaLibras: function(peso) {
            return parseFloat(peso) * 2,20462;
        },
        
        doFormParaUmCavaleiro: function($cavaleiro) {
            // Obtém o objeto nativo Form através da posição 0 no objeto jQuery e cria um FormData a partir dele
            var cavaleiro = new FormData($cavaleiro[0]);
            var imagens = new Array();
            $cavaleiro.find(".imagens .imagem").each(function() {
                imagens.push({url: $(this).find("input[type=text]").val(), isThumb:$(this).find("input[type=checkbox]").is(":checked")})
            });
            
            return {
                id: App.ListaDeCavaleiros.goldSaints.length+1,
                nome: cavaleiro.get("nome"),
                tipoSanguineo: cavaleiro.get("tipoSanguineo"),
                dataNascimento: App.Converte.deDataBrParaPadraoISO(cavaleiro.get("dataNascimento")),
                alturaCm: App.Converte.deMetrosParaCentimetros(cavaleiro.get("altura")),
                pesoLb: App.Converte.deKgParaLibras(cavaleiro.get("peso")),
                signo: cavaleiro.get("signo"),
                localNascimento: cavaleiro.get("localNascimento"),
                localTreinamento: cavaleiro.get("localTreinamento"),
                golpes: cavaleiro.getAll("golpes[]"),
                imagens: imagens
            };
        }
    };
    
    App.ListaDeCavaleiros.iniciar();
    App.CadastroDeCavaleiros.iniciar();
})();