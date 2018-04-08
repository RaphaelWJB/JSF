package br.com.project.util.all;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class Mensagens extends FacesContext implements Serializable {

	private static final long serialVersionUID = 1L;

	public Mensagens() {

	}

	public static void erroNaOperacao() {
		if (facesContextValido()) {
			msgFatal(Constante.ERRO_NA_OPERACAO);
		}
	}

	public static void msg(String msg) {
		if (facesContextValido()) {
			getFacesContext().addMessage("msg", new FacesMessage(msg));
		}
	}

	public static void sucesso() {
		msgInfo(Constante.OPERACAO_REALIZADA_COM_SUCESSO);
	}

	public static void responseOperation(EstatusPersistencia estatusPersistencia) {
		if (estatusPersistencia != null && estatusPersistencia.equals(EstatusPersistencia.SUCESSO)) {
			sucesso();
		}else if(estatusPersistencia != null && estatusPersistencia.equals(EstatusPersistencia.OBJETO_REFERENCIADO)) {
			msgFatal(EstatusPersistencia.OBJETO_REFERENCIADO.toString());
		}else {
			erroNaOperacao();
		}
	}
	
	public static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	private static boolean facesContextValido() {
		return getFacesContext() != null;
	}

	public static void msgWarn(String msg) {
		if (facesContextValido()) {
			getFacesContext().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg));
		}
	}
	
	public static void msgFatal(String msg) {
		if (facesContextValido()) {
			getFacesContext().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, msg));
		}
	}
	
	public static void msgErro(String msg) {
		if (facesContextValido()) {
			getFacesContext().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
		}
	}

	public static void msgInfo(String msg) {
		if (facesContextValido()) {
			getFacesContext().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
		}
	}
}
