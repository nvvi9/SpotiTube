package com.nvvi9.spotitube.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastFirst
import com.nvvi9.spotitube.utils.bouncingSelectable
import kotlin.math.roundToInt

@Composable
fun SpotitubeBottomNavigation(modifier: Modifier = Modifier, navigationItems: @Composable RowScope.() -> Unit) {
    val gradientBrush = remember {
        Brush.verticalGradient(
            colorStops = arrayOf(
                0.0f to Color.Black,
                0.3f to Color.Black.copy(alpha = 0.9f),
                0.5f to Color.Black.copy(alpha = 0.8f),
                0.7f to Color.Black.copy(alpha = 0.6f),
                0.9f to Color.Black.copy(alpha = 0.2f),
                1f to Color.Transparent
            ),
            startY = Float.POSITIVE_INFINITY,
            endY = 0.0f
        )
    }

    Surface(
        modifier = modifier.background(gradientBrush),
        color = Color.Transparent
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .selectableGroup(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            navigationItems()
        }
    }
}

@Composable
fun RowScope.TabNavigationItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    label: @Composable () -> Unit,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    selectedContentColor: Color = Color.White,
    unselectedContentColor: Color = selectedContentColor.copy(alpha = 0.6f)
) {
    var itemWidth by remember { mutableIntStateOf(0) }

    val contentColor = if (selected) selectedContentColor else unselectedContentColor

    val styledIcon = @Composable {
        Box(modifier = Modifier.clearAndSetSemantics {}) {
            CompositionLocalProvider(LocalContentColor provides contentColor, content = icon)
        }
    }

    val styledLabel = @Composable {
        CompositionLocalProvider(LocalContentColor provides contentColor, content = label)
    }

    Box(
        modifier = Modifier
            .bouncingSelectable(
                selected = selected,
                onClick = onClick,
                interactionSource = interactionSource,
                role = Role.Tab
            )
            .defaultMinSize(minHeight = 80.dp)
            .weight(1f)
            .onSizeChanged {
                itemWidth = it.width
            },
        contentAlignment = Alignment.Center,
        propagateMinConstraints = true
    ) {
        Layout({
            Box(Modifier.layoutId(IconLayoutTag)) { styledIcon() }
            Box(
                Modifier
                    .layoutId(LabelLayoutTag)
                    .padding(horizontal = 4.dp)
            ) {
                styledLabel()
            }
        }) { measurables, constraints ->
            val looseConstraints = constraints.copy(minWidth = 0, minHeight = 0)

            val iconPlaceable =
                measurables.fastFirst { it.layoutId == IconLayoutTag }.measure(looseConstraints)
            val labelPlaceable =
                measurables.fastFirst { it.layoutId == LabelLayoutTag }.measure(looseConstraints)

            val contentHeight =
                iconPlaceable.height + IndicatorVerticalPadding.toPx() + IndicatorToLabelPadding.toPx() + labelPlaceable.height
            val contentVerticalPadding = ((constraints.minHeight - contentHeight) / 2)
                .coerceAtLeast(IndicatorVerticalPadding.toPx())
            val height = contentHeight + contentVerticalPadding * 2

            val labelY =
                contentVerticalPadding + iconPlaceable.height + IndicatorVerticalPadding.toPx() + IndicatorToLabelPadding.toPx()

            val containerWidth = constraints.maxWidth

            val labelX = (containerWidth - labelPlaceable.width) / 2
            val iconX = (containerWidth - iconPlaceable.width) / 2

            layout(containerWidth, height.roundToInt()) {
                labelPlaceable.placeRelative(labelX, labelY.roundToInt())
                iconPlaceable.placeRelative(iconX, contentVerticalPadding.roundToInt())
            }
        }
    }
}

private const val IconLayoutTag = "icon"
private const val LabelLayoutTag = "label"
private val IndicatorVerticalPadding = 4.dp
private val IndicatorToLabelPadding = 4.dp