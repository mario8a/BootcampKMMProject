package com.mariochoa.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import bootcampkmmproject.composeapp.generated.resources.Overlock_Bold
import bootcampkmmproject.composeapp.generated.resources.Overlock_Regular
import bootcampkmmproject.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)


@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colorScheme = if (darkTheme) darkScheme else lightScheme

    val typography = Typography(
        displayLarge = TextStyle(
            fontSize = 57.sp,
            fontFamily = FontFamily(Font(Res.font.Overlock_Bold))
        ),
        displayMedium = TextStyle(
            fontSize = 45.sp,
            fontFamily = FontFamily(Font(Res.font.Overlock_Bold))
        ),
        displaySmall = TextStyle(
            fontSize = 36.sp,
            fontFamily = FontFamily(Font(Res.font.Overlock_Bold))
        ),
        headlineLarge = TextStyle(
            fontSize = 32.sp,
            fontFamily = FontFamily(Font(Res.font.Overlock_Bold))
        ),
        headlineMedium = TextStyle(
            fontSize = 28.sp,
            fontFamily = FontFamily(Font(Res.font.Overlock_Bold))
        ),
        headlineSmall = TextStyle(
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(Res.font.Overlock_Bold))
        ),
        titleLarge = TextStyle(
            fontSize = 22.sp,
            fontFamily = FontFamily(Font(Res.font.Overlock_Regular))
        ),
        titleMedium = TextStyle(
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(Res.font.Overlock_Regular))
        ),
        titleSmall = TextStyle(
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(Res.font.Overlock_Regular))
        ),
        bodyLarge = TextStyle(
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(Res.font.Overlock_Regular))
        ),
        bodyMedium = TextStyle(
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(Res.font.Overlock_Regular))
        ),
        bodySmall = TextStyle(
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(Res.font.Overlock_Regular))
        ),
        labelLarge = TextStyle(
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(Res.font.Overlock_Regular))
        ),
        labelMedium = TextStyle(
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(Res.font.Overlock_Regular))
        ),
        labelSmall = TextStyle(
            fontSize = 11.sp,
            fontFamily = FontFamily(Font(Res.font.Overlock_Regular))
        )
    )


    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = content
    )
}

