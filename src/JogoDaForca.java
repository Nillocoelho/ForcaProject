
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class JogoDaForca {
    private ArrayList<String> palavras = new ArrayList();
    private ArrayList<String> dicas = new ArrayList<>();
    private int tentativa;
    private String palavraEscolhida;
    private ArrayList<String> palavraAdivinhada = new ArrayList<>();
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
            System.out.println(this.palavras);
            System.out.println(this.dicas);

        }
    }
    public void iniciar() {
        this.tentativa = 0;
        this.acertos = 0;
        this.penalidades = 0;
        Random random = new Random();
        int n = random.nextInt( 10);
        this.palavraEscolhida = this.palavras.get(n).toLowerCase();
        this.dicaEscolhida = this.dicas.get(n);
        this.palavraAdivinhada.clear();
    }
    public String getDica() { return this.dicaEscolhida; };
    public int getTamanho() {
        return this.palavraEscolhida.length();
    };

    public ArrayList<Integer> getOcorrencias(String letra) throws Exception {
        ArrayList<Integer> o = new ArrayList<>();
        String p = this.palavraEscolhida.toLowerCase();

        if (letra.isEmpty()){
            throw new Exception("Insira uma letra válida.");
        }
        else if (letra.length() > 2) {
            throw new Exception("Insira apenas uma letra.");
        }
        else if (this.palavraAdivinhada.contains(letra)) {
            throw new Exception("Insira uma letra que ainda não foi escolhida.");
        }
        else {
            for (int n = 0; n < p.length(); n++) {
                if (p.substring(n).equalsIgnoreCase(letra)) {
                    this.palavraAdivinhada.add(n, letra);
                    o.add(n+1);
                    this.acertos += 1;
                } else {
                    this.penalidades += 1;
                }
            }
        }

        return o;
    }

    public boolean terminou() {
        return (this.palavraEscolhida.equalsIgnoreCase(this.getPalavraAdivinhada())) || (this.tentativa == 6);
    }
    public String getPalavraAdivinhada() {
        StringBuilder r = new StringBuilder();
        for (String item : this.palavraAdivinhada) {
            if (item.isEmpty()) {
                r.append("*");
            }
            r.append(item);
        }
        return r.toString();
    }

    public int getAcertos()  { return this.acertos; }

    public int getNumeroPenalidade() { return this.penalidades; }

    public String getNomePenalidade() {
        String p = "";
        if (this.tentativa == 1) {
            p = "Apareceu a cabeça.";
        } else if (this.tentativa == 2) {
            p = "Apareceu o tronco.";
        } else if (this.tentativa == 3) {
            p = "Apareceu o primeiro braço.";
        } else if (this.tentativa == 4) {
            p = "Apareceu o segundo braço.";
        } else if (this.tentativa == 5) {
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
