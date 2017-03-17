package com.training.prevenda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class EnderecosUsuarioBean {
	
		private List<Integer> enderecos;

		public  EnderecosUsuarioBean() {
			enderecos = new ArrayList<>();
			enderecos.add(1);
			enderecos.add(1);
		}

		public List<Integer> getEnderecos() {
			return enderecos;
		}


}
