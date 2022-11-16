@file:JvmName("TestJvmKt")

package matt.test

import matt.lang.YesIUseLang
import matt.lang.disabledButDefinitelyStillInByteCodeCode
import org.junit.jupiter.api.extension.AfterTestExecutionCallback
import kotlin.test.DefaultAsserter
import kotlin.test.junit5.JUnit5Asserter



fun yesIUseTestLibs() {
  YesIUseLang
  disabledButDefinitelyStillInByteCodeCode {
	val yesIUseJUnitHereIsSomethingNotInlined = AfterTestExecutionCallback { TODO("Not yet implemented") }
	val hereIsAnother = JUnit5Asserter
	println(yesIUseJUnitHereIsSomethingNotInlined.afterTestExecution(null))
	println(hereIsAnother.assertTrue({ "I'm so lazy" }, false))
  }
}


fun assertTrueLazyMessage(
  test: Boolean,
  message: ()->String
) = DefaultAsserter.assertTrue(
  lazyMessage = message,
  actual = test
)


