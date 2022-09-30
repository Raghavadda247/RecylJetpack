package com.example.recycjetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.example.recycjetpack.model.Movie

@Composable
fun ItemView(movie: Movie) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Surface() {
          Row(
              Modifier
                  .padding(4.dp)
                  .fillMaxSize()
          )  {
              //dependecy of coil to be added for loading images from url
              Image(painter = rememberImagePainter(data = movie.imageUrl,
              builder = {
                  scale(Scale.FIT)
                  placeholder(coil.base.R.drawable.notification_action_background)
                  transformations(CircleCropTransformation())
              }), contentDescription = movie.desc, modifier = Modifier
                  .fillMaxWidth()
                  .height(200.dp)
                  .weight(.2f)
                  .padding(5.dp))
              Column(
                  verticalArrangement = Arrangement.Center,
                  modifier = Modifier
                      .padding(4.dp)
                      .fillMaxHeight()
                      .weight(.8f)
              ) {
                  Text(text = "Name: " + movie.name, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 5.dp, bottom = 5.dp))
                  Text(text = "Category: " + movie.category,modifier = Modifier.padding(start = 5.dp, bottom = 5.dp))

              }
          }
        }

    }
}
