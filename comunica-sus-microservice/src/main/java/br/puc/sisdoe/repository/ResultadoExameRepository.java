package br.puc.sisdoe.repository;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;
import br.puc.sisdoe.model.Coleta;
import br.puc.sisdoe.model.Doador;
import br.puc.sisdoe.model.ResultadoExame;
import br.puc.sisdoe.model.ResultadoExameAIDS;
import br.puc.sisdoe.model.ResultadoExameDoencaChagas;
import br.puc.sisdoe.model.ResultadoExameHepatiteB;
import br.puc.sisdoe.model.ResultadoExameHepatiteC;
import br.puc.sisdoe.model.ResultadoExameSifilis;
import br.puc.sisdoe.util.DateUtil;

@Repository
public class ResultadoExameRepository {

	private List<ResultadoExame> resultadosExames;
	
	public ResultadoExameRepository() {
		
		ResultadoExame resultadoExame1 = new ResultadoExame();
		resultadoExame1.setId(1L);
		resultadoExame1.setDoador(new Doador("Wesley Melo", "02805333144", "2811592", DateUtil.formataDataPadraoBR("25/03/1992"), "Masculino"));
		resultadoExame1.setColeta(new Coleta(Boolean.TRUE, "A", DateUtil.formataDataPadraoBR("10/09/2016")));
		resultadoExame1.setResultadoExameAIDS(new ResultadoExameAIDS(Boolean.FALSE));
		resultadoExame1.setResultadoExameDoencaChagas(new ResultadoExameDoencaChagas(0.2, 0.3, 0.4, 0.5));
		resultadoExame1.setResultadoExameHepatiteB(new ResultadoExameHepatiteB(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
		resultadoExame1.setResultadoExameHepatiteC(new ResultadoExameHepatiteC(Boolean.FALSE));
		resultadoExame1.setResultadoExameSifilis(new ResultadoExameSifilis(Boolean.FALSE));
		
		ResultadoExame resultadoExame2 = new ResultadoExame();
		resultadoExame2.setId(2L);
		resultadoExame2.setDoador(new Doador("Fábio Júnior", "02839566185", "92441345", DateUtil.formataDataPadraoBR("14/07/1890"), "Masculino"));
		resultadoExame2.setColeta(new Coleta(Boolean.FALSE, "AB", DateUtil.formataDataPadraoBR("30/07/2016")));
		resultadoExame2.setResultadoExameAIDS(new ResultadoExameAIDS(Boolean.FALSE));
		resultadoExame2.setResultadoExameDoencaChagas(new ResultadoExameDoencaChagas(0.4, 0.7, 0.9, 0.1));
		resultadoExame2.setResultadoExameHepatiteB(new ResultadoExameHepatiteB(Boolean.FALSE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE));
		resultadoExame2.setResultadoExameHepatiteC(new ResultadoExameHepatiteC(Boolean.TRUE));
		resultadoExame2.setResultadoExameSifilis(new ResultadoExameSifilis(Boolean.TRUE));
		
		ResultadoExame resultadoExame3 = new ResultadoExame();
		resultadoExame3.setId(3L);
		resultadoExame3.setDoador(new Doador("Renata Assunção", "10378922309", "8233481", DateUtil.formataDataPadraoBR("01/12/1993"), "Feminino"));
		resultadoExame3.setColeta(new Coleta(Boolean.FALSE, "O", DateUtil.formataDataPadraoBR("01/08/2016")));
		resultadoExame3.setResultadoExameAIDS(new ResultadoExameAIDS(Boolean.TRUE));
		resultadoExame3.setResultadoExameDoencaChagas(new ResultadoExameDoencaChagas(0.1, 0.3, 0.2, 0.5));
		resultadoExame3.setResultadoExameHepatiteB(new ResultadoExameHepatiteB(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE));
		resultadoExame3.setResultadoExameHepatiteC(new ResultadoExameHepatiteC(Boolean.FALSE));
		resultadoExame3.setResultadoExameSifilis(new ResultadoExameSifilis(Boolean.TRUE));
		
		ResultadoExame resultadoExame4 = new ResultadoExame();
		resultadoExame4.setId(4L);
		resultadoExame4.setDoador(new Doador("Diego de Souza Queiroz", "99948399467", "9394583", DateUtil.formataDataPadraoBR("30/09/1965"), "MASCULINO"));
		resultadoExame4.setColeta(new Coleta(Boolean.TRUE, "B", DateUtil.formataDataPadraoBR("12/07/2016")));
		resultadoExame4.setResultadoExameAIDS(new ResultadoExameAIDS(Boolean.FALSE));
		resultadoExame4.setResultadoExameDoencaChagas(new ResultadoExameDoencaChagas(0.8, 0.5, 0.1, 0.7));
		resultadoExame4.setResultadoExameHepatiteB(new ResultadoExameHepatiteB(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
		resultadoExame4.setResultadoExameHepatiteC(new ResultadoExameHepatiteC(Boolean.TRUE));
		resultadoExame4.setResultadoExameSifilis(new ResultadoExameSifilis(Boolean.FALSE));
		
		ResultadoExame resultadoExame5 = new ResultadoExame();
		resultadoExame5.setId(5L);
		resultadoExame5.setDoador(new Doador("Alan Bruno de Silva", "96634399467", "2398456", DateUtil.formataDataPadraoBR("08/11/1964"), "MASCULINO"));
		resultadoExame5.setColeta(new Coleta(Boolean.TRUE, "O", DateUtil.formataDataPadraoBR("11/06/2016")));
		resultadoExame5.setResultadoExameAIDS(new ResultadoExameAIDS(Boolean.FALSE));
		resultadoExame5.setResultadoExameDoencaChagas(new ResultadoExameDoencaChagas(0.8, 0.5, 0.1, 0.7));
		resultadoExame5.setResultadoExameHepatiteB(new ResultadoExameHepatiteB(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
		resultadoExame5.setResultadoExameHepatiteC(new ResultadoExameHepatiteC(Boolean.TRUE));
		resultadoExame5.setResultadoExameSifilis(new ResultadoExameSifilis(Boolean.FALSE));
		
		ResultadoExame resultadoExame6 = new ResultadoExame();
		resultadoExame6.setId(6L);
		resultadoExame6.setDoador(new Doador("Benedita de Melo dos Santos", "60192968149", "1434331", DateUtil.formataDataPadraoBR("10/10/1960"), "FEMININO"));
		resultadoExame6.setColeta(new Coleta(Boolean.TRUE, "AB", DateUtil.formataDataPadraoBR("06/08/2016")));
		resultadoExame6.setResultadoExameAIDS(new ResultadoExameAIDS(Boolean.FALSE));
		resultadoExame6.setResultadoExameDoencaChagas(new ResultadoExameDoencaChagas(0.8, 0.5, 0.1, 0.7));
		resultadoExame6.setResultadoExameHepatiteB(new ResultadoExameHepatiteB(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
		resultadoExame6.setResultadoExameHepatiteC(new ResultadoExameHepatiteC(Boolean.FALSE));
		resultadoExame6.setResultadoExameSifilis(new ResultadoExameSifilis(Boolean.FALSE));
		
		ResultadoExame resultadoExame7 = new ResultadoExame();
		resultadoExame7.setId(7L);
		resultadoExame7.setDoador(new Doador("Francisco Pereira Silva", "56897422211", "3654789", DateUtil.formataDataPadraoBR("12/12/1970"), "MASCULINO"));
		resultadoExame7.setColeta(new Coleta(Boolean.FALSE, "O", DateUtil.formataDataPadraoBR("01/07/2016")));
		resultadoExame7.setResultadoExameAIDS(new ResultadoExameAIDS(Boolean.FALSE));
		resultadoExame7.setResultadoExameDoencaChagas(new ResultadoExameDoencaChagas(0.8, 0.5, 0.1, 0.7));
		resultadoExame7.setResultadoExameHepatiteB(new ResultadoExameHepatiteB(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
		resultadoExame7.setResultadoExameHepatiteC(new ResultadoExameHepatiteC(Boolean.FALSE));
		resultadoExame7.setResultadoExameSifilis(new ResultadoExameSifilis(Boolean.FALSE));
		
		ResultadoExame resultadoExame8 = new ResultadoExame();
		resultadoExame8.setId(8L);
		resultadoExame8.setDoador(new Doador("Julio Valente", "36987422544", "3654782", DateUtil.formataDataPadraoBR("28/02/1972"), "MASCULINO"));
		resultadoExame8.setColeta(new Coleta(Boolean.FALSE, "O", DateUtil.formataDataPadraoBR("24/08/2016")));
		resultadoExame8.setResultadoExameAIDS(new ResultadoExameAIDS(Boolean.FALSE));
		resultadoExame8.setResultadoExameDoencaChagas(new ResultadoExameDoencaChagas(0.8, 0.5, 0.1, 0.7));
		resultadoExame8.setResultadoExameHepatiteB(new ResultadoExameHepatiteB(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
		resultadoExame8.setResultadoExameHepatiteC(new ResultadoExameHepatiteC(Boolean.FALSE));
		resultadoExame8.setResultadoExameSifilis(new ResultadoExameSifilis(Boolean.FALSE));
		
		ResultadoExame resultadoExame9 = new ResultadoExame();
		resultadoExame9.setId(9L);
		resultadoExame9.setDoador(new Doador("Paulo Corrêa", "35896477155", "6899452", DateUtil.formataDataPadraoBR("24/08/1978"), "MASCULINO"));
		resultadoExame9.setColeta(new Coleta(Boolean.FALSE, "O", DateUtil.formataDataPadraoBR("24/08/2016")));
		resultadoExame9.setResultadoExameAIDS(new ResultadoExameAIDS(Boolean.FALSE));
		resultadoExame9.setResultadoExameDoencaChagas(new ResultadoExameDoencaChagas(0.8, 0.5, 0.1, 0.7));
		resultadoExame9.setResultadoExameHepatiteB(new ResultadoExameHepatiteB(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
		resultadoExame9.setResultadoExameHepatiteC(new ResultadoExameHepatiteC(Boolean.FALSE));
		resultadoExame9.setResultadoExameSifilis(new ResultadoExameSifilis(Boolean.FALSE));
		
		ResultadoExame resultadoExame10 = new ResultadoExame();
		resultadoExame10.setId(10L);
		resultadoExame10.setDoador(new Doador("Ana Silva Lúcia", "98752366411", "23659841", DateUtil.formataDataPadraoBR("20/05/1986"), "FEMININO"));
		resultadoExame10.setColeta(new Coleta(Boolean.FALSE, "AB", DateUtil.formataDataPadraoBR("03/03/2016")));
		resultadoExame10.setResultadoExameAIDS(new ResultadoExameAIDS(Boolean.FALSE));
		resultadoExame10.setResultadoExameDoencaChagas(new ResultadoExameDoencaChagas(0.8, 0.5, 0.1, 0.7));
		resultadoExame10.setResultadoExameHepatiteB(new ResultadoExameHepatiteB(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
		resultadoExame10.setResultadoExameHepatiteC(new ResultadoExameHepatiteC(Boolean.FALSE));
		resultadoExame10.setResultadoExameSifilis(new ResultadoExameSifilis(Boolean.FALSE));
		
		ResultadoExame resultadoExame11 = new ResultadoExame();
		resultadoExame11.setId(11L);
		resultadoExame11.setDoador(new Doador("Roberto Tôgo", "69875214665", "1258694", DateUtil.formataDataPadraoBR("12/06/1989"), "MASCULINO"));
		resultadoExame11.setColeta(new Coleta(Boolean.FALSE, "A", DateUtil.formataDataPadraoBR("04/06/2016")));
		resultadoExame11.setResultadoExameAIDS(new ResultadoExameAIDS(Boolean.FALSE));
		resultadoExame11.setResultadoExameDoencaChagas(new ResultadoExameDoencaChagas(0.8, 0.5, 0.1, 0.7));
		resultadoExame11.setResultadoExameHepatiteB(new ResultadoExameHepatiteB(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
		resultadoExame11.setResultadoExameHepatiteC(new ResultadoExameHepatiteC(Boolean.FALSE));
		resultadoExame11.setResultadoExameSifilis(new ResultadoExameSifilis(Boolean.FALSE));
				
		resultadosExames = Arrays.asList(resultadoExame1, resultadoExame2, resultadoExame3, resultadoExame4, resultadoExame5, resultadoExame6, resultadoExame7, resultadoExame8, resultadoExame9, resultadoExame10, resultadoExame11);
	}
	
	public List<ResultadoExame> findAll() {
		return resultadosExames;
	}
	
}
