package br.com.tw.util;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class GeradoraDeFigurinhas {


    public void cria() throws Exception {

        // leitura da imagem

        BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme.jpg"));

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
        ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));


    }

    public static void main(String[] args) throws Exception {

        GeradoraDeFigurinhas gerador = new GeradoraDeFigurinhas();
        gerador.cria();
    }

}