package gallerie.model;

import java.util.Objects;

public class Galleria {
	private final int codGalleria;
	private final String codFiscaleResponsabile;
	private final long valoreComplessivo;
	private final String via;
	private final int numCivico;
	private final String citta;
	
	public Galleria(final int codGalleria, final String codFiscale, final long valoreComplessivo, final String via,
					final int numCivico, final String citta) {
		this.codGalleria = codGalleria;
		this.codFiscaleResponsabile = Objects.requireNonNull(codFiscale);
		this.valoreComplessivo = valoreComplessivo;
		this.via = Objects.requireNonNull(via);
		this.numCivico = numCivico;
		this.citta = Objects.requireNonNull(citta);
	}

	public int getCodGalleria() {
		return codGalleria;
	}

	public String getCodFiscaleResponsabile() {
		return codFiscaleResponsabile;
	}

	public long getValoreComplessivo() {
		return valoreComplessivo;
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
		return Objects.hash(codGalleria, codFiscaleResponsabile, valoreComplessivo, via, numCivico, citta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Galleria other = (Galleria) obj;
		if (citta == null) {
			if (other.citta != null)
				return false;
		} else if (!citta.equals(other.citta))
			return false;
		if (codFiscaleResponsabile == null) {
			if (other.codFiscaleResponsabile != null)
				return false;
		} else if (!codFiscaleResponsabile.equals(other.codFiscaleResponsabile))
			return false;
		if (codGalleria != other.codGalleria)
			return false;
		if (numCivico != other.numCivico)
			return false;
		if (valoreComplessivo != other.valoreComplessivo)
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
		return "Galleria [codGalleria=" + codGalleria + ", codFiscaleResponsabile=" + codFiscaleResponsabile
				+ ", valoreComplessivo=" + valoreComplessivo + ", via=" + via + ", numCivico=" + numCivico + ", citta="
				+ citta + "]";
	}
	
	

}
