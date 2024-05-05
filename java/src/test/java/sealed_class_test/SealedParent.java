package sealed_class_test;

/**
 * sealed 키워드로 상속을 허용할 자식 클래스들을 permits 할 수 있다.
 */
sealed class SealedParent permits FinalChild, NonSealedChild {
}
