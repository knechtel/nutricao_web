
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import br.com.nutricao.JpaController.AtividadeJpaControllerRemote;
import br.com.nutricao.JpaController.PacienteJpaController;
import br.com.nutricao.JpaController.PacienteJpaControllerRemote;
import br.com.nutricao.bean.Atividade;
import br.com.nutricao.bean.Paciente;
import br.com.nutricao.controller.UsuarioBean;

@SuppressWarnings("deprecation")
@ManagedBean
@ViewScoped
public class AgendaBeanUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ScheduleModel model;
	private ScheduleModel eventModel;
	private Atividade atividade;

	private List<Atividade>	listAtividade;		

	@Inject
	private UsuarioBean usuario;

	private ScheduleEvent event = new DefaultScheduleEvent();
	@EJB
	private AtividadeJpaControllerRemote atividadeJpa;
	
	private PacienteJpaControllerRemote pacienteJpaRemote;

	@PostConstruct
	public void init() {
		System.out.println("inicio +++++++++++++++++++++");
		//listAtividade = pacienteJpaRemote.findAtividade(usuario.getUsuario().getPaciente()).getListAtividade();
		
		System.out.println("teste->. "+usuario.getNome());
	
		
		Integer id  = usuario.getIdPaciente();
		System.out.println("testando - >> id [ "+id+" ]");
		Paciente pacienteLocal = pacienteJpaRemote.findAtividade(id);
		if(pacienteLocal==null) {
			System.out.println("++++++++++++ paciente nullo");
		}
		else {
		listAtividade = pacienteJpaRemote.findAtividade(usuario.getIdPaciente()).getListAtividade();
		}
		if(listAtividade==null) {
			listAtividade = new ArrayList<Atividade>();
		}
		eventModel = new DefaultScheduleModel();
		//eventModel.addEvent(new DefaultScheduleEvent("Champions League Match", new Date(), new Date()));
		
		for(Atividade a:listAtividade) {
			
			eventModel.addEvent(new DefaultScheduleEvent(a.getDescricao(), a.getDataHoraInicio(), a.getDataHoraFim()));
					
		}
		
	}
	
	public AgendaBeanUser() {
		
		
	}

	public ScheduleModel getModel() {
		return model;
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public void setModel(ScheduleModel model) {
		this.model = model;
	}

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	public void addEvent(ActionEvent actionEvent) {
		if (event.getId() == null)
			eventModel.addEvent(event);
		else
			eventModel.updateEvent(event);

		System.out.println("----------------+++++++++++++");
		 event = new DefaultScheduleEvent();
	
		List<ScheduleEvent> listEventos = eventModel.getEvents();

		for (ScheduleEvent e : listEventos) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>");
			System.out.println(e.getTitle());
			System.out.println("123456789");
		}

	}

	public void onEventSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
	}

	public void onDateSelect(SelectEvent selectEvent) {
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
	}

	public void onEventMove(ScheduleEntryMoveEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved",
				"Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);
	}

	public void onEventResize(ScheduleEntryResizeEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized",
				"Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);
	}

	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}



	public List<Atividade> getListAtividade() {
		return listAtividade;
	}

	public void setListAtividade(List<Atividade> listAtividade) {
		this.listAtividade = listAtividade;
	}



}
