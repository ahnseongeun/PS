package DataStructure.미분류;

class 카펫 {
	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int width=brown/2; int height=0;
		for(int i=1;i<brown/2;i++) {
			--width;
			++height;
			if((width-2)*height==yellow)
			{
				answer[0]= width;
				answer[1]= height+2;
				break;
			}
		}
        return answer;
    }
}
