package me.otomir23.partyverse.ui.permissions

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun PermissionPopup(
    icon: ImageVector,
    explanation: String,
    display: Boolean,
    onClick: () -> Unit,
    onDismiss: () -> Unit = {}
) {
    val context = LocalContext.current

    if (display) {
        Dialog(onDismissRequest = onDismiss) {
            Surface(
                color = MaterialTheme.colors.background,
                modifier = Modifier
                    .padding(4.dp)
                    .border(1.dp, MaterialTheme.colors.primary, RoundedCornerShape(4.dp))
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(icon, contentDescription = "Permission", tint = MaterialTheme.colors.primary)
                    Text(text = explanation)
                    Button(
                        onClick = onClick,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = context.getString(android.R.string.ok))
                    }
                }
            }
        }
    }
}