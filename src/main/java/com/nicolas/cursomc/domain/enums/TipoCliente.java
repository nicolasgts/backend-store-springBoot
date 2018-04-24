package com.nicolas.cursomc.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int codigo;
	private String descricao;
	
	
	// remember that constructor of enums is private
	private TipoCliente(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	// remember that enums just have get methods , no set methods
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	
	// this method will return the enum when we give the code of the ClienteType
	public static TipoCliente toEnum(Integer codigo) {
		
		if(codigo == null) return null;
		
		for (TipoCliente tipoCliente : TipoCliente.values()) {
			if(codigo.equals(tipoCliente.codigo)) return tipoCliente;
		}
		
		throw new IllegalArgumentException("Id : " + codigo + " é inválido");
	}

}
