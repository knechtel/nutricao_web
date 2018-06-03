


import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
@ManagedBean
@ViewScoped
public class TestBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ScheduleModel model;
	private ScheduleModel eventModel;
	public TestBean() {
		  eventModel = new DefaultScheduleModel();
	        eventModel.addEvent(new DefaultScheduleEvent("Champions League Match", new Date(), new Date()));
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
	
	
}
