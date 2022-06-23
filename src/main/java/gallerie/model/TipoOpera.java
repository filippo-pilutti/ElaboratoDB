package gallerie.model;

import java.util.Objects;

public class TipoOpera {
	private final int codTipo;
	private final String nome;
	private final String descrizione;
	
	public TipoOpera(final int codTipo, final String nome, final String descrizione) {
		this.codTipo = codTipo;
		this.nome = Objects.requireNonNull(nome);
		this.descrizione = Objects.requireNonNull(descrizione);
	}

	public int getCodTipo() {
		return codTipo;
	}

	public String getNome() {
		return nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codTipo, nome, descrizione);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoOpera other = (TipoOpera) obj;
		if (codTipo != other.codTipo)
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoOpera [codTipo=" + codTipo + ", nome=" + nome + ", descrizione=" + descrizione + "]";
	}
	
	

}
