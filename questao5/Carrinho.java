package questao5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carrinho {

    private List<ItemCarrinho> itens = new ArrayList<>();

    public void adicionarItem(ItemCarrinho item) {
        itens.add(item);
    }

    public List<ItemCarrinho> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public double calcularSubtotal() {
        double subtotal = 0;

        for (ItemCarrinho item : itens) {
            subtotal += item.calcularSubtotal();
        }

        return subtotal;
    }

    public double calcularDesconto() {
        return calcularSubtotal() * 0.10;
    }

    public double calcularFrete() {
        return 20;
    }

    public double calcularTotal() {
        return calcularSubtotal()
                - calcularDesconto()
                + calcularFrete();
    }
}