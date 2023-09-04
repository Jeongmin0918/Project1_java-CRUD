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

    public void addItem(){
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

    public ArrayList<Integer> listAll(String keyword){
        ArrayList<Integer> idlist = new ArrayList<>();
        int j = 0;
        System.out.println("--------------------------------");
        for(int i=0; i<list.size(); i++){
            String word = list.get(i).getName();
            if(!word.contains(keyword)) continue;
            //word가 이 영어를 포함하지 않았으면 continue
            System.out.print((j+1) + " ");
            //이미 추가하면서 보여주는 함수를 만들었기 때문에 끌고와서 사용
            System.out.println(list.get(i).toString());
            idlist.add(i); //화면에 출력될 번호를 idlist에 추가 i는 int 지만 자동으로integer로 변환
            j++;
        }
        System.out.println("--------------------------------");
        //wordManager에서 호출하기
        return idlist;
        //return 타입도 list
    }

    public void updateItem() {
        //update 를 위해 wordmanager에서 추가
        System.out.print("==> 수정할 단어 검색 : ");
        String keyword = s.next();
        //next => 공백허용 안함
        ArrayList<Integer> idlist = this.listAll(keyword);
        //idlist return값을 받는부분,
        System.out.print("==> 수정할 번호 선택 : ");
        int id = s.nextInt();
        s.nextLine();
        System.out.print("=> 뜻 입력 : ");
        String meaning = s.nextLine();
        Word word = list.get(idlist.get(id-1));
        word.setMeaning(meaning);
        System.out.print("단어가 수정되었습니다.\n");
    }

    public void deleteItem() {
        //update와 비슷해서 복사
        System.out.print("==> 삭제할 단어 검색 : ");
        String keyword = s.next();
        //next => 공백허용 안함
        ArrayList<Integer> idlist = this.listAll(keyword);
        //idlist return값을 받는부분,
        System.out.print("==> 삭제할 번호 선택 : ");
        int id = s.nextInt();
        s.nextLine();
        System.out.print("=> 정말로 삭제하실래요?(Y/n) : ");
        String ans = s.next();
        if(ans.equalsIgnoreCase("y")){
            list.remove((int)idlist.get(id-1));
            System.out.println("단어가 삭제되었습니다. ");
        } else System.out.println("취소되었습니다. ");
    }
}
