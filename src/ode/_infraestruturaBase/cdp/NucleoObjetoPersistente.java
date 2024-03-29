package ode._infraestruturaBase.cdp;

import java.io.Serializable;




public interface NucleoObjetoPersistente<I, V>
		extends NucleoObjetoDominio {

	/**
	 * Retorna o atributo identificador (chave-prim�ria).
	 * 
	 * @return O identificador do objeto.
	 */
	I getId();

	/**
	 * Retorna o atributo de versionamento.
	 * 
	 * @return Atributo de vers�o.
	 */
	V getVersion();

	/**
	 * Verifica se o objeto � persistente.
	 * 
	 * @return <code>true</code> se o objeto � persistente, <code>false</code>
	 *         caso contr�rio.
	 */
	boolean isPersistente();

}
