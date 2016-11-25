package controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean
public class MapBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private MapModel simpleModel;

	@PostConstruct
	public void init() {
		simpleModel = new DefaultMapModel();
		LatLng coord1 = new LatLng(39.93336, 32.85974);
		simpleModel.addOverlay(new Marker(coord1, "Ankara"));
	}

	public MapModel getSimpleModel() {
		return simpleModel;
	}
}