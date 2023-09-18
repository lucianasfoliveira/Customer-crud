A Ada tech pretendo realizar a venda de produtos através de um E-Commerce e, para isso, nos contratou com a finalidade de desenvolvermos todo o fluxo necessário. Nesse E-Commerce temos algumas necessidades que serão descritas abaixo.

Cadastrar, listar, atualizar os clientes da base. Não é necessário a ação de excluir clientes, pois esses devem permanecer na base como histórico.
Cadastrar, listar, atualizar os produtos da base. Não é necessário a ação de excluir produtos, pois esses devem permanecer na base como histórico.
Criar uma venda para um cliente. Nessa venda deve ser possível: Adicionar item (produto) com quantidade e preço, remover item (produto), alterar quantidade do item (produto), realizar o pagamento e a entrega.
Regras importantes que foram levantadas junto ao nosso cliente.

Todo cliente cadastrado precisa ter o documento de identificação.
Um pedido sempre deve ter a data em que foi criado.
Um pedido sempre deve iniciar com o status igual a aberto.
Pedidos com status igual a aberto podem receber itens (produto), alterar quantidade e remover item.
Os produtos adicionados ao pedido devem ter um valor de venda informado, pois esse valor pode ser diferente do valor do produto.
Para que o cliente possa realizar a ação de finalizar o pedido, o pedido deve ter ao menos um item e o valor deve ser maior que zero. Também deve-se alterar o status do pagamento para: "Aguardando pagamento" e notificar o cliente via e-mail.
A ação de pagar deve acontecer apenas sobre vendas que estejam com o status igual a "Aguardando pagamento" e, após o pagamento acontecer com sucesso, deve-se alterar o status do pagamento para "Pago" e, também, notificar o cliente.
Após o pagamento realizado o pedido pode ser entregue ao cliente e o status alterado para "Finalizado". Não esqueça de notificar o cliente sobre a entrega.
