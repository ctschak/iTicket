package assets

import controllers.AssetsBuilder
import play.api.mvc.{AnyContent, Action}

object Assets extends AssetsBuilder {
  
  private val path = "/client"
  
  def at(file: String): Action[AnyContent] = {
    at(path, file)
  }
  
  
  
} 