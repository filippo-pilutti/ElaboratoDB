package gallerie.model;

import java.util.Objects;

public class Museo {
	private final String nome;
	private final int codMuseo;
	private final long telefono;
	private final String via;
	private final int numCivico;
	private final String citta;
	
	public Museo(final String nome, final int codMuseo, final long telefono, final String via, final int numCivico,
				 final String citta) {
		this.nome = Objects.requireNonNull(nome);
		this.codMuseo = codMuseo;
		this.telefono = telefono;
		this.via = Objects.requireNonNull(via);
		this.numCivico = numCivico;
		this.citta = Objects.requireNonNull(citta);
	}

	public String getNome() {
		return nome;
	}

	public int getCodMuseo() {
		return codMuseo;
	}

	public long getTelefono() {
		return telefono;
	}

	public String getVia() {
		return via;
	}

	public int getNumCivico() {
		return numCivico;
	}

	public String getCitta() {
		return citta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, codMuseo, telefono, via, numCivico, citta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Museo other = (Museo) obj;
		if (citta == null) {
			if (other.citta != null)
				return false;
		} else if (!citta.equals(other.citta))
			return false;
		if (codMuseo != other.codMuseo)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numCivico != other.numCivico)
			return false;
		if (telefono != other.telefono)
			return false;
		if (via == null) {
			if (other.via != null)
				return false;
		} else if (!via.equals(other.via))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Museo [nome=" + nome + ", codMuseo=" + codMuseo + ", telefono=" + telefono + ", via=" + via
				+ ", numCivico=" + numCivico + ", citta=" + citta + "]";
	}
	
	
	

}
