package me.nathan.domain.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="tb_account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="saldo", precision = 2)
	private BigDecimal saldo;

	@Column(name="restrito", precision = 2)
	private BigDecimal saldoRestrito;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public BigDecimal getSaldoRestrito() {
		return saldoRestrito;
	}

	public void setSaldoRestrito(BigDecimal saldoRestrito) {
		this.saldoRestrito = saldoRestrito;
	}
	
}
