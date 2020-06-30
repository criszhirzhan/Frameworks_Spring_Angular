package ec.edu.ups.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Telefono implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@ManyToOne
	@JoinColumn
	private Usuario usuario;
	@Column(nullable = false, length = 5)
	private String tipo;
	@Column(nullable = false, length = 8)
	private String operadora;
	@Column(nullable = false, length = 10)
	private String numero;
	
	
	public Telefono() {
		
	}


	public Telefono(int codigo, String tipo, String operadora, String numero) {
		this.codigo = codigo;
		this.tipo = tipo;
		this.operadora = operadora;
		this.numero = numero;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getOperadora() {
		return operadora;
	}


	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	@Override
	public String toString() {
		return "Telefono [codigo=" + codigo + ", usuario=" + usuario.getCedula() + ", tipo=" + tipo + ", operadora=" + operadora
				+ ", numero=" + numero + "]";
	}
	
	
	
	
	

}
