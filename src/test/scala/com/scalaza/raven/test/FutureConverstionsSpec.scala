package com.scalaza.raven.test

import com.scalaza.raven.future.Conversions._
import com.scalaza.raven.future.test.TwitterFutures
import com.twitter.util.{Future => TwitterFuture}
import org.scalatest._
import org.scalatest.concurrent.ScalaFutures

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future => ScalaFuture}

class FutureConverstionsSpec extends FlatSpec with Matchers
{
  "Hello" should "have tests" in {
    true should === (true)
  }

  "Scala Future" should "convert to twitter Future" in {
    val message = "From scala future"
    val scalaFuture: ScalaFuture[String] = ScalaFuture {
      "From scala future"
    }
    TwitterFutures.whenReady(scalaFuture.toTwitterFuture) { msg =>
      msg should be (message)
    }
  }

  "Twitter Future" should "convert to scala Future" in {
    val message = "From twitter future"
    val twitterFuture: TwitterFuture[String] = TwitterFuture.value(message)

    ScalaFutures.whenReady(twitterFuture.toScalaFuture) { msg =>
      msg should be (message)
    }
  }

}
