
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JogoDaForca {
    private ArrayList<String> palavras = new ArrayList<>();
    private ArrayList<String> dicas = new ArrayList<>();
    private String palavraEscolhida;
    private String[] palavraAdivinhada;
    private String dicaEscolhida;
    private int penalidades;
    private int acertos;

    public JogoDaForca() throws Exception {
        InputStream stream = this.getClass().getResourceAsStream("/dados/palavras.txt");
        Scanner arquivo;
        if (stream == null) {
            throw new Exception("Arquivo de palavras inexistente");
        } else {
            arquivo = new Scanner(stream);
            while (arquivo.hasNext()) {
                String linha = arquivo.nextLine().toUpperCase();
                this.palavras.add(linha.split(";")[0]);
                this.dicas.add(linha.split(";")[1]);
            }

            arquivo.close();

        }
    }
    public void iniciar() {
        this.acertos = 0;
        this.penalidades = 0;
        Random random = new Random();
        int n = random.nextInt(10);
        this.palavraEscolhida = this.palavras.get(n).toLowerCase();
        this.dicaEscolhida = this.dicas.get(n);
        this.palavraAdivinhada = new String[this.palavraEscolhida.length()];
        Arrays.fill(this.palavraAdivinhada, "*");
    }
    public String getDica() { return this.dicaEscolhida; };
    public int getTamanho() { return this.palavraEscolhida.length(); };

    public ArrayList<Integer> getOcorrencias(String letra) throws Exception {
        ArrayList<Integer> o = new ArrayList<>(this.palavraEscolhida.length());
        String p = this.palavraEscolhida.toLowerCase();
        String s = this.getPalavraAdivinhada();

        if (letra.isEmpty()){
            throw new Exception("Insira uma letra.");
        }
        else if (letra.length() >= 2) {
            throw new Exception("Insira apenas uma letra.");
        }
        else if (s.contains(letra)){
            throw new Exception("Você já digitou a letra" + " " + letra.toUpperCase());
        }
        else {
            int c = 0;
            for (int n = 0; n < p.length(); n++) {
                if (p.substring(n, n+1).equalsIgnoreCase(letra)) {
                    this.palavraAdivinhada[n] = letra;
                    o.add(n+1);
                    this.acertos += 1;
                    c += 1;
                }
            }

            if (c == 0) {
                this.penalidades += 1;
            }
            return o;
        }
    }

    public boolean terminou() {
        return (this.palavraEscolhida.equalsIgnoreCase(this.getPalavraAdivinhada())) || (this.penalidades == 6);
    }
    public String getPalavraAdivinhada() {
        String r = "";
        for (String item : this.palavraAdivinhada) {
            r+=(item);
        }
        return r;
    }

    public int getAcertos()  { return this.acertos; }

    public int getNumeroPenalidade() { return this.penalidades; }

    public String getNomePenalidade() {
        String p = "";
        if (this.penalidades == 0)  {
            p = "Sem penalidades.";
        } else if (this.penalidades == 1) {
            p = "Apareceu a cabeça.";
        } else if (this.penalidades == 2) {
            p = "Apareceu o tronco.";
        } else if (this.penalidades == 3) {
            p = "Apareceu o primeiro braço.";
        } else if (this.penalidades == 4) {
            p = "Apareceu o segundo braço.";
        } else if (this.penalidades == 5) {
            p = "Apareceu primeira perna.";
        } else {
            p = "Apareceu segunda perna.";
        }
        return p;
    }

    public String getResultado() {
        if (!this.terminou()) {
            return "jogo em andamento";
        } else {
            return this.palavraEscolhida.equalsIgnoreCase(this.getPalavraAdivinhada()) ? "Você venceu" : "Você foi enforcado!";
        }
    }
}
