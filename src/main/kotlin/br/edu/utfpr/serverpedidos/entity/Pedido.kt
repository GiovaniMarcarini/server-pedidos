package br.edu.utfpr.serverpedidos.entity

import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity
class Pedido (
    @Id
    @GeneratedValue
    var id: Int = 0,
    @Column(updatable = false)
    var data: ZonedDateTime = ZonedDateTime.now(),
    @Enumerated(value = EnumType.STRING)
    var status: StatusPedido = StatusPedido.AGUARDANDO,
    @ManyToOne(optional = false)
    var cliente: Cliente? = null,
    @OneToMany(mappedBy = "id.pedido", cascade = [CascadeType.ALL], orphanRemoval = true)
    var produtos: List<PedidoProduto> = listOf(),
)

enum class StatusPedido{
    AGUARDANDO,
    FATURADO,
    ENVIADO,
    ENTREGUE
}