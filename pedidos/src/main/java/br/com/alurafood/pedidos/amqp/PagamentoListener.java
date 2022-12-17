package br.com.alurafood.pedidos.amqp;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.alurafood.pedidos.dto.PagamentoDTO;

@Component
public class PagamentoListener {

    @RabbitListener(queues = "pagamentos.detalhes-pedido")
    public void recebeMensagem(PagamentoDTO pagamento) {
        String mensagem = String.format("Dados do pagamento: %s\n Número do pedido: %s\n Valor R$: %s\n Status: %s\n",
                pagamento.getId(),
                pagamento.getPedidoId(),
                pagamento.getValor(),
                pagamento.getStatus());
        System.out.println("Recebi a mensagem " + mensagem.toString());
    }
}