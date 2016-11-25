package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CalculationBean {
	private boolean first = false;
	private boolean second = false;
	private boolean third = false;
	private boolean forth = false;
	private boolean fifth = false;
	
	private List<String> cinsiyetList = new ArrayList<>();
 
	private int boy;
	private int kilo;
	private int yas;

	private String cinsiyet;

	private int secim;
	public int sonuc;

	public CalculationBean() {
		cinsiyetList.add("erkek");
		cinsiyetList.add("kadin");
	}

	public void bazal() {
		System.out.println(cinsiyet + "geldi");
	}

	public void updatableForm(int id) {
		switch (id) {
		case 1:
			first = true;
			break;
		case 2:

			second = true;

			break;
		case 3:

			third = true;

			break;
		case 4:

			forth = true;

			break;
		case 5:

			fifth = true;
			break;

		}

	}
	
	


	public void bedenKitle() {

	}

	public void belCevresi() {

	}

	public void gunluk() {

	}

	public void yagYakma() {

	}
	
	
	

	public List<String> getCinsiyetList() {
		return cinsiyetList;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public boolean isSecond() {
		return second;
	}

	public void setSecond(boolean second) {
		this.second = second;
	}

	public boolean isThird() {
		return third;
	}

	public void setThird(boolean third) {
		this.third = third;
	}

	public boolean isForth() {
		return forth;
	}

	public void setForth(boolean forth) {
		this.forth = forth;
	}

	public boolean isFifth() {
		return fifth;
	}

	public void setFifth(boolean fifth) {
		this.fifth = fifth;
	}

	public int getBoy() {
		return boy;
	}

	public void setBoy(int boy) {
		this.boy = boy;
	}

	public int getKilo() {
		return kilo;
	}

	public void setKilo(int kilo) {
		this.kilo = kilo;
	}

	public int getYas() {
		return yas;
	}

	public void setYas(int yas) {
		this.yas = yas;
	}

	public int getSonuc() {
		return sonuc;
	}

	public void setSonuc(int sonuc) {
		this.sonuc = sonuc;
	}

	public String getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	public int getSecim() {
		return secim;
	}

	public void setSecim(int secim) {
		this.secim = secim;
	}
}
