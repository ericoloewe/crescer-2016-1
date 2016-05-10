﻿using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;

namespace Repositorio
{
    public class RepositorioFuncionarios
    {
        public List<Funcionario> Funcionarios { get; private set; }

        public RepositorioFuncionarios()
        {
            CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor1 = new Cargo("Desenvolvedor Júnior", 190);
            Cargo desenvolvedor2 = new Cargo("Desenvolvedor Pleno", 250);
            Cargo desenvolvedor3 = new Cargo("Desenvolvedor Sênior", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Marcelinho Carioca", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor1;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Mark Zuckerberg", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor1;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Aioros de Sagitário", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor1;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Uchiha Madara", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor1;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Barack Obama", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor1;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Whindersson  Nunes", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor1;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Optimus Prime", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor1;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Arnold Schwarzenegger", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor1;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Bill Gates", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = desenvolvedor2;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Linus Torvalds", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = desenvolvedor2;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Dollynho Developer", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = desenvolvedor3;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            return Funcionarios.Where(f => f.Cargo.Equals(cargo)).ToList();
        }

        public IList<Funcionario> OrdenadosPorCargo()
        {
            return Funcionarios.OrderBy(f => f.Cargo.Titulo).ThenBy(f => f.Nome).ToList();
        }

        public IList<Funcionario> BuscarPorNome(string nome)
        {
            return Funcionarios.Where(f => f.Nome.IndexOf(nome, StringComparison.CurrentCultureIgnoreCase) >= 0).ToList();
        }        

        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turnos)
        {
            return (turnos.Length > 0) ? Funcionarios.Where(f => turnos.Contains(f.TurnoTrabalho)).ToList() : Funcionarios;
        }        

        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            return
                Funcionarios.Where(f => {
                                        var idadeF = (DateTime.Now.Subtract(f.DataNascimento).TotalDays/364.5);
                                        return idadeF >= (idade - 5) && idadeF <= (idade + 5);
                                    }).ToList();
        }        

        public double SalarioMedio(TurnoTrabalho? turno = null)
        {
            return turno == null ? Funcionarios.Average(f => f.Cargo.Salario) : Funcionarios.Where(f => f.TurnoTrabalho.Equals(turno)).Average(f => f.Cargo.Salario);
        }

        public IList<Funcionario> AniversariantesDoMes()
        {
            return Funcionarios.Where(f => f.DataNascimento.Month.Equals(DateTime.Now.Month)).ToList();
        }

        public IList<dynamic> BuscaRapida()
        {
            return Funcionarios.Select(f => new
            {
                NomeFuncionario = f.Nome,
                TituloCargo = f.Cargo.Titulo
            }).ToArray();
        }

        public IList<dynamic> QuantidadeFuncionariosPorTurno()
        {
            return Funcionarios.GroupBy(f => f.TurnoTrabalho).Select(f => new
            {
                Turno = f.Key,
                Quantidade = f.Count()
            }).ToArray();
        }

        public dynamic FuncionarioMaisComplexo()
        {
            var vogais = new List<string> { "a", "e", "i", "o", "u" };
            int maximoDeVogaisEmUmFuncionario = Funcionarios.Where(f => f.Cargo.Titulo != "Desenvolvedor Júnior" && f.TurnoTrabalho != TurnoTrabalho.Tarde).Max(f => f.Nome.Count(fn => vogais.Contains(fn.ToString())));
            var funcionarioMaisComplexo = Funcionarios.FirstOrDefault(f => f.Nome.Count(fn => vogais.Contains(fn.ToString())) == maximoDeVogaisEmUmFuncionario);

            return new
            {
                funcionarioMaisComplexo.Nome,
                DataNascimento = funcionarioMaisComplexo.DataNascimento.ToString("dd/M/yyyy"),
                SalarioRS = string.Format("{0:C2}", funcionarioMaisComplexo.Cargo.Salario),
                SalarioUS = string.Format(new CultureInfo("en-US", false), "{0:C2}", funcionarioMaisComplexo.Cargo.Salario),
                QuantidadeMesmoCargo = BuscarPorCargo(funcionarioMaisComplexo.Cargo).Count
            };
        }
    }
}
