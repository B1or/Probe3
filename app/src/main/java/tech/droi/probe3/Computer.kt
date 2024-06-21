package tech.droi.probe3

class Processor {
    override fun toString() = "Intel"
}
class Motherboard {
    override fun toString() = "ASUS"
}
class RAM {
    override fun toString() = "16 GB"
}
data class Computer(
    val processor: Processor,
    val motherboard: Motherboard,
    val ram: RAM
    )
data class Axe(val value: Int = 7)
