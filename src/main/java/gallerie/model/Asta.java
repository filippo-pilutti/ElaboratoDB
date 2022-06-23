package gallerie.model;

import java.util.Date;
import java.util.Objects;

public class Asta {
	private final int numPartecipanti;
	private final Date data;
	private final int baseAsta;
	private final int codAsta;
	private final int codArtista;
	private final String titoloOpera;
	
	public Asta(final int numPartecipanti, final Date data, final int baseAsta, final int codAsta, final int codArtista,
				final String titoloOpera) {
		this.numPartecipanti = numPartecipanti;
		this.data = Objects.requireNonNull(data);
		this.baseAsta = baseAsta;
		this.codAsta = codAsta;
		this.codArtista = codArtista;
		this.titoloOpera = Objects.requireNonNull(titoloOpera);
	}

	public int getNumPartecipanti() {
		return numPartecipanti;
	}

	public Date getData() {
		return data;
	}

	public int getBaseAsta() {
		return baseAsta;
	}

	public int getCodAsta() {
		return codAsta;
	}

	public int getCodArtista() {
		return codArtista;
	}

	public String getTitoloOpera() {
		return titoloOpera;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numPartecipanti, data, baseAsta, codAsta, codArtista, titoloOpera);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asta other = (Asta) obj;
		if (baseAsta != other.baseAsta)
			return false;
		if (codArtista != other.codArtista)
			return false;
		if (codAsta != other.codAsta)
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (numPartecipanti != other.numPartecipanti)
			return false;
		if (titoloOpera == null) {
			if (other.titoloOpera != null)
				return false;
		} else if (!titoloOpera.equals(other.titoloOpera))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Asta [numPartecipanti=" + numPartecipanti + ", data=" + data + ", baseAsta=" + baseAsta + ", codAsta="
				+ codAsta + ", codArtista=" + codArtista + ", titoloOpera=" + titoloOpera + "]";
	}
	

}
