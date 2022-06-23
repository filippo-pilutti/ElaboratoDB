package gallerie.model;

import java.util.Objects;

public class Offerta {
	private final int codAsta;
	private final int numeroOfferta;
	private final long importo;
	private final String cliente;
	
	public Offerta(final int codAsta, final int numeroOfferta, final long importo, final String cliente) {
		this.codAsta = codAsta;
		this.numeroOfferta = numeroOfferta;
		this.importo = importo;
		this.cliente = Objects.requireNonNull(cliente);
	}

	public int getCodAsta() {
		return codAsta;
	}

	public int getNumeroOfferta() {
		return numeroOfferta;
	}

	public long getImporto() {
		return importo;
	}

	public String getCliente() {
		return cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codAsta, numeroOfferta, importo, cliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offerta other = (Offerta) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (codAsta != other.codAsta)
			return false;
		if (importo != other.importo)
			return false;
		if (numeroOfferta != other.numeroOfferta)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Offerta [codAsta=" + codAsta + ", numeroOfferta=" + numeroOfferta + ", importo=" + importo
				+ ", cliente=" + cliente + "]";
	}
	
	

}
