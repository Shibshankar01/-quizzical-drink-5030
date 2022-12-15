package com.travelzilla.models;

	

import java.util.Objects;

<<<<<<< HEAD:TravelZilla/src/main/java/com/travelzilla/models/Package.java
=======
import com.fasterxml.jackson.annotation.JsonIgnore;

>>>>>>> 9e10bba05273986d70539cbe28f376fc69f6124d:TravelZilla/src/main/java/com/travelzilla/models/Packages.java
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Packages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer packageId;


	@NotBlank(message = "Package Name Cannot Be Blank!")
	@Size(min = 10, max = 100, message = "Package Name Length must be between 10 to 100 characters.")
	private String packageName;

	@NotBlank(message = "Package Description Cannot Be Blank!")
	@Size(min = 10, max = 1000, message = "Package Description Length must be between 10 to 1000 characters.")
	private String packageDescription;

	@NotNull(message = "Route Cannot Be Null!")
	@Min(value = 1, message = "Invalid Route ID, must be > 0")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "routeId")
	@JsonIgnore
	private Route route;

	@NotNull(message = "Hotel Cannot Be Null!")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hotel_Id")
	@JsonIgnore
	private Hotel hotel;

	@NotNull(message = "Bus Cannot be Null")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "busId")
	@JsonIgnore
	private Bus bus;

	@NotNull(message = "Package Cost Cannot be Null")
	@Min(value = 2000, message = "Package Cost Cannot be Less Than 2000.")
	private Integer packageCost;

	public Packages() {
		// TODO Auto-generated constructor stub
	}

	public Packages(Integer packageId, String packageName, String packageDescription, Route route, Hotel hotel, Bus bus,
			Integer packageCost) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.packageDescription = packageDescription;
		this.route = route;
		this.hotel = hotel;
		this.bus = bus;
		this.packageCost = packageCost;

	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageDescription() {
		return packageDescription;
	}

	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	public Route getRouteId() {
		return route;
	}

	public void setRouteId(Route route) {
		this.route = route;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Integer getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(Integer packageCost) {
		this.packageCost = packageCost;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bus, hotel, packageCost, packageDescription, packageId, packageName, route);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Packages other = (Packages) obj;
		return Objects.equals(bus, other.bus) && Objects.equals(hotel, other.hotel)
				&& Objects.equals(packageCost, other.packageCost)
				&& Objects.equals(packageDescription, other.packageDescription)
				&& Objects.equals(packageId, other.packageId) && Objects.equals(packageName, other.packageName)
				&& Objects.equals(route, other.route);
	}

	@Override
	public String toString() {
		return "Package [packageId=" + packageId + ", packageName=" + packageName + ", packageDescription="
				+ packageDescription + ", route=" + route + ", hotel=" + hotel + ", bus=" + bus + ", packageCost="
				+ packageCost + "]";
	}


}
