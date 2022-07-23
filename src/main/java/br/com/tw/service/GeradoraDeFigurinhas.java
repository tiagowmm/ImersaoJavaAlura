package br.com.tw.service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class GeradoraDeFigurinhas {


    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        // leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria nova imagem em memória com transparencia e com novo tamanho.
        String texto = "TOPZERA";
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

        // calcular centralizacao
        int novaLargura = ((largura / 2) - (texto.length() * 20)) ;

        // escrever uma frase na nova imagem
        graphics.drawString(texto, novaLargura, (novaAltura - 100));

        // escrever a nova imagem em um arquivo.
        ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));

    }

}
