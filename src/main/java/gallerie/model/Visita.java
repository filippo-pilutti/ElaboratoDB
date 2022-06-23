package gallerie.model;

import java.util.Date;
import java.util.Objects;

public class Visita {
	private final int codGalleria;
	private final String codFiscaleCliente;
	private final Date dataVisita;
	
	public Visita(final int codGalleria, final String codFiscaleCliente, final Date dataVisita) {
		this.codGalleria = codGalleria;
		this.codFiscaleCliente = Objects.requireNonNull(codFiscaleCliente);
		this.dataVisita = Objects.requireNonNull(dataVisita);
	}

	public int getCodGalleria() {
		return codGalleria;
	}

	public String getCodFiscaleCliente() {
		return codFiscaleCliente;
	}

	public Date getDataVisita() {
		return dataVisita;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codGalleria, codFiscaleCliente, dataVisita);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visita other = (Visita) obj;
		if (codFiscaleCliente == null) {
			if (other.codFiscaleCliente != null)
				return false;
		} else if (!codFiscaleCliente.equals(other.codFiscaleCliente))
			return false;
		if (codGalleria != other.codGalleria)
			return false;
		if (dataVisita == null) {
			if (other.dataVisita != null)
				return false;
		} else if (!dataVisita.equals(other.dataVisita))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Visita [codGalleria=" + codGalleria + ", codFiscaleCliente=" + codFiscaleCliente + ", dataVisita="
				+ dataVisita + "]";
	}
	
	

}
