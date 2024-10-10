import java.util.Scanner
/**
 * Calculates the Air Quality Index (AQI) based on PM2.5 and PM10 levels.
 *
 * The AQI is calculated using a simple average of PM2.5 and PM10 levels, with equal weighting.
 *
 * @param pm25 The level of PM2.5 particulate matter in µg/m³.
 * @param pm10 The level of PM10 particulate matter in µg/m³.
 * @return The calculated AQI value as an integer.
 */

fun calculateAQI(pm25: Double, pm10: Double): Int {
    return ((pm25 * 0.5) + (pm10 * 0.5)).toInt()
}

/**
 * Provides a suggested action based on the AQI level.
 *
 * The suggestions are based on predefined AQI ranges, with specific actions recommended for each range.
 *
 * @param aqi The Air Quality Index value to evaluate.
 * @return A string message suggesting actions based on the AQI level.
 */

fun provideSolution(aqi: Int): String {
    if (aqi in 0..50) {
        return "The air quality is excellent, and no major actions are necessary."
    } else if (aqi in 51..100) {
        return "The air quality is moderate. It's advisable to promote the use of public transportation and minimize vehicle usage."
    } else if (aqi in 101..150) {
        return "Not suitable for sensitive groups. It is recommended to limit outdoor activities."
    } else if (aqi in 151..200) {
        return "Unhealthy conditions. Enforce vehicle restrictions and promote working from home."
    } else if (aqi in 201..300) {
        return "\n" +
                "Extremely unhealthy. Limit industrial emissions."
    } else {
        return "\n" +
                "Dangerous levels. Implement rigorous pollution control measures."
    }
}


/**
 * Main function to execute the AQI calculation and provide suggestions based on user input.
 *
 * Prompts the user to enter PM2.5 and PM10 levels, calculates the AQI, and prints the AQI value along with the suggested action.
 */
fun main() {
    val scanner = Scanner(System.`in`)

    // Ask for PM2.5 level
    print("Enter PM2.5 level (in µg/m³): ")
    val pm25 = scanner.nextDouble()

    // Ask for PM10 level
    print("Enter PM10 level (in µg/m³): ")
    val pm10 = scanner.nextDouble()

    // Calculate AQI
    val aqi = calculateAQI(pm25, pm10)

    // Print AQI result
    println("\nAir Quality Index (AQI): $aqi")

    // Provide suggested solution based on AQI
    val solution = provideSolution(aqi)
    println("Suggested Action: $solution")
}
