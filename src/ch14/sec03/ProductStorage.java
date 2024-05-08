package ch14.sec03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProductStorage {
    private List<Product> list = new ArrayList<>();
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private int counter;

    public void showMenu() throws IOException {
        while (true) {
            System.out.println("----------------------------------");
            System.out.println("1. 등록 | 2. 목록 | 3. 종료");
            System.out.println("----------------------------------");

            System.out.print("선택: ");
            String selectNo = br.readLine();
            switch (selectNo) {
                case "1":
                    registerProduct();
                    break;
                case "2":
                    showProduct();
                    break;
                case "3":
                    return;
            }
        }
    }

    public void registerProduct() {
        try {
            Product product = new Product();
            product.setPno(++counter);

            System.out.print("상품명 : ");
            product.setName(br.readLine());

            System.out.print("가격 : ");
            product.setPrice(Integer.parseInt(br.readLine()));

            System.out.print("재고 : ");
            product.setStock(Integer.parseInt(br.readLine()));

            list.add(product);
        } catch (Exception e) {
            System.out.println(" 등록 애러 : " + e.getMessage());
        }
    }

    public void showProduct() {
        for (Product p : list) {
            System.out.println(p.getPno() + "\t" + p.getName() + "\t" + p.getPrice() + "\t" + p.getStock());
        }
    }
}
