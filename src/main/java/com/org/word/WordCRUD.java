package com.org.word;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    ArrayList<Word> list;
    Scanner s;

    WordCRUD(Scanner s){
        list = new ArrayList<>();
        this.s = s;
    }

    /*
    => 난이도(1,2,3) & 새 단어 입력 : 1 driveway
    뜻 입력 : 차고 진입로
    새 단어가 단어장에 추가되었습니다 !!!
     */

    @Override
    public Object add() {
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
        int level = s.nextInt();
        String name = s.nextLine();

        System.out.print("뜻 입력 : ");
        String meaning = s.nextLine();

        return new Word(0, level, name, meaning);
    }

    public void addWord(){
        Word one = (Word)add();
        list.add(one);

        System.out.println("새 단어가 단어장에 추가되었습니다 !!!");
    }

    @Override
    public int update(Object obj) {
        return 0;
    }

    @Override
    public int delete(Object obj) {
        return 0;
    }

    @Override
    public void selectOne(int num) {

    }
    /*
    => 원하는 메뉴는? 1
    --------------------------------
    1 * driveway 차고 진입로
    2 ** graceful 우아한
    --------------------------------
     */
    public void listAll(){
        System.out.println("--------------------------------");
        for(int i=0; i<list.size(); i++){
            System.out.print((i+1) + " ");
            //이미 추가하면서 보여주는 함수를 만들었기 때문에 끌고와서 사용
            System.out.println(list.get(i).toString());
        }
        System.out.println("--------------------------------");
        //wordManager에서 호출하기
    }
}
