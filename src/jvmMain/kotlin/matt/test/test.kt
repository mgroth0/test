@file:JvmName("TestJvmKt")

package matt.test

import matt.lang.YesIUseLang
import matt.lang.disabledButDefinitelyStillInByteCodeCode
import matt.model.data.dir.YesOrNo.NO
import matt.service.action.ActionAbilitiesService
import matt.test.prop.DO_MANUAL_TESTS
import org.junit.jupiter.api.extension.AfterTestExecutionCallback
import kotlin.test.DefaultAsserter
import kotlin.test.fail
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


fun testConfirmation(
  prompt: String,
  abilitiesService: ActionAbilitiesService
) {
  when (abilitiesService.yesOrNo(prompt)) {
	NO   -> fail("manual test confirmation was NOT confirmed: \"$prompt\"")
	else -> {/*do nothing*/
	}
  }
}


val SHOULD_DO_MANUAL_TESTS by lazy {
  System.getProperty(DO_MANUAL_TESTS, "false").toBoolean()
}