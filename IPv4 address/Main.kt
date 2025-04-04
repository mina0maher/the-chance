//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
}

fun isIPv4Valid(ip: Any?): Boolean {
    if (ip !is String) return false

    val trimmedIp = ip.trim()
    if (trimmedIp.isEmpty() || trimmedIp != ip) return false

    val numbers = trimmedIp.split(".")
    if (numbers.size != 4) return false

    for (segment in numbers) {
        val num = segment.toIntOrNull() ?: return false
        if (num !in 0..255) return false
        if (segment.startsWith("0") && segment.length > 1) return false
    }

    return true
}

