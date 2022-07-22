package br.com.tw.util;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

public class GeradoraDeFigurinhas {


    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        // leitura da imagem

//        InputStream inputStream = new FileInputStream(new File("inputStream/filme.jpg"));
//        InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria nova imagem em memória com transparencia e com novo tamanho.

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para nova imagem (em memória)

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar fonte

        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem

        graphics.drawString("TOPZERA", 0, (novaAltura - 100));

        // escrever a nova imagem em um arquivo.
//        ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));
        ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));

    }

//    public static void main(String[] args) throws Exception {
//
//        GeradoraDeFigurinhas gerador = new GeradoraDeFigurinhas();
//        gerador.cria();
//    }

}
