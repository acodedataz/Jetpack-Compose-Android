package com.shanto.learnjeetpackcompose.`9_AlertDialogBox`

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.shanto.learnjeetpackcompose.R

@Composable
fun BeautifulAlertDialog() {

    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {

        Dialog(
            onDismissRequest = {
                showDialog = false
            }
        ) {

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(28.dp),
                elevation = CardDefaults.cardElevation(12.dp)
            ) {

                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .padding(bottom = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // Top Image Section
                    Image(
                        painter = painterResource(R.drawable.ai_automation),
                        contentDescription = "Dialog Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(220.dp)
                            .clip(
                                RoundedCornerShape(
                                    topStart = 28.dp,
                                    topEnd = 28.dp
                                )
                            )
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    // Title
                    Text(
                        text = "Delete File?",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // Description
                    Text(
                        text = "Are you sure you want to delete this file? This action cannot be undone.",
                        modifier = Modifier.padding(horizontal = 24.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Buttons
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        // Cancel Button
                        OutlinedButton(
                            onClick = {
                                showDialog = false
                            },
                            shape = RoundedCornerShape(14.dp)
                        ) {
                            Text("Cancel")
                        }

                        // Delete Button
                        Button(
                            onClick = {

                                Toast.makeText(
                                    context,
                                    "File Deleted",
                                    Toast.LENGTH_SHORT
                                ).show()

                                showDialog = false
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFE53935)
                            ),
                            shape = RoundedCornerShape(14.dp)
                        ) {
                            Text("Delete")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ShowBeautifulDialog() {
    BeautifulAlertDialog()
}