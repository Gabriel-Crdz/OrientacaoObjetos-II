package enums;

public enum ContinenteEnum {
    AF(1, "Africa"),
    AN(2, "America do Norte"),
    AS(3, "America do SUl"),
    AI(4, "Asia"),
    EU(5, "Europa"),
    OC(6, "Oceania");

    private final int chave;
    private final String descricao;

    ContinenteEnum(int chave, String descricao) {
        this.chave = chave;
        this.descricao = descricao;
    }

    public int getChave() {
        return chave;
    }

    public String getdescricao() {
        return descricao;
    }

    public static ContinenteEnum fromChave(int chave) {
        for (ContinenteEnum c : values()) {
            if (c.getChave() == chave) {
                return c;
            }
        }
        throw new IllegalArgumentException("Continente inválido");
    }
}
