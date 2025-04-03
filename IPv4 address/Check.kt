fun main() {
    //region valid
    validateIPv4(
        name = "when IPv4 address is valid and in range return true",
        result = isIPv4Valid("192.168.1.1"),
        correctResult = true
    )
    validateIPv4(
        name = "when IPv4 address is valid and have the maximum range return true",
        result = isIPv4Valid("255.255.255.255"),
        correctResult = true
    )
    validateIPv4(
        name = "when IPv4 address is valid and have the lower range return true",
        result = isIPv4Valid("0.0.0.0"),
        correctResult = true
    )
    //endregion

    //region not valid


    //region type is not String
    validateIPv4(
        name = "when IPv4 address is null return false",
        result = isIPv4Valid(null),
        correctResult = false
    )
    validateIPv4(
        name = "when IPv4 address is not string return false",
        result = isIPv4Valid(1.5f),
        correctResult = false
    )


    //endregion

    //region limits
    validateIPv4(
        name = "when IPv4 address exceeds the the maximum limit return false",
        result = isIPv4Valid("192.168.256.1"),
        correctResult = false
    )
    validateIPv4(
        name = "when IPv4 address have negative number return false",
        result = isIPv4Valid("-1.168.1.1"),
        correctResult = false
    )
    //endregion

    validateIPv4(
        name = "when IPv4 address have leading zeros return false",
        result = isIPv4Valid("192.168.01.1"),
        correctResult = false
    )
    validateIPv4(
        name = "when IPv4 address is empty string return false",
        result = isIPv4Valid(""),
        correctResult = false
    )
    validateIPv4(
        name = "when IPv4 address have empty segment return false",
        result = isIPv4Valid("192..1.1"),
        correctResult = false
    )
    validateIPv4(
        name = "when IPv4 address have more than 3 dots return false",
        result = isIPv4Valid("192.168.1.1.1"),
        correctResult = false
    )
    validateIPv4(
        name = "when IPv4 address have less than 3 dots return false",
        result = isIPv4Valid("192.168.1"),
        correctResult = false
    )
    validateIPv4(
        name = "when IPv4 address have character return false",
        result = isIPv4Valid("192.168.a.1"),
        correctResult = false
    )
    validateIPv4(
        name = "when IPv4 address have only dots with spaces return false",
        result = isIPv4Valid("   .   .   .   "),
        correctResult = false
    )
    validateIPv4(
        name = "when IPv4 address have not dots return false",
        result = isIPv4Valid("19216811"),
        correctResult = false
    )
    validateIPv4(
        name = "when IPv4 address have slashes instead of dots return false",
        result = isIPv4Valid("192/168/1/1"),
        correctResult = false
    )
    validateIPv4(
        name = "when IPv4 address have symbols return false",
        result = isIPv4Valid("192.$%.1.1"),
        correctResult = false
    )
    validateIPv4(
        name = "when IPv4 address have leading spaces return false",
        result = isIPv4Valid(" 192.168.1.1 "),
        correctResult = false
    )

    //endregion
}

fun validateIPv4(name: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult) {
        println("Success - $name")
    } else {
        println("Failed - $name")
    }
}

