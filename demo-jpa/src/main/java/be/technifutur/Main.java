package be.technifutur;

import be.technifutur.entities.Category;
import be.technifutur.entities.Customer;
import be.technifutur.entities.Product;
import be.technifutur.entities.Supplier;
import be.technifutur.repository.ProductRepository;
import be.technifutur.repository.SupplierRepository;
import be.technifutur.repository.impl.ProductRepositoryImpl;
import be.technifutur.repository.impl.SupplierRepositoryImpl;
import be.technifutur.utils.EMFSharer;
import jakarta.persistence.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProductRepository productRepository = new ProductRepositoryImpl();
        SupplierRepository supplierRepository = new SupplierRepositoryImpl();

        // -- list all product with price between 1 & 10
        // List<Product> products = productRepository.getUnitPriceBetween(1, 10);
        // products.forEach(p -> System.out.printf("- %s %f\n", p.getName(), p.getUnitPrice()));
        List<Supplier> supplierList = supplierRepository.getSuppliersByRegion("Québec");
        supplierList.forEach(s -> System.out.printf("- Supplier company name: %s, region: %s\n", s.getCompanyName(), s.getRegion()));
        //supplierRepository.addVipLabelToSupplierCompanyNameFromRegion("Québec - VIP");
        //supplierList.forEach(s -> System.out.printf("- Supplier company name: %s, region: %s\n", s.getCompanyName(), s.getRegion()));

        // -- reduce first entity price
        // Product product = products.get(0);
        // product.setUnitPrice(11.);
        // productRepository.update(product.getId(), product);

        // -- delete id 78
        // productRepository.remove(78L);

        // -- add
        // Product p = productRepository.getOne(1L).orElseThrow();
        // System.out.printf("- %s %f\n", p.getName(), p.getUnitPrice());
        // p.setId(90L);
        // p.setName(p.getName() + " copy");
        // productRepository.add(p);

        EMFSharer.getInstance().getEmf().close();

        /*
        ** before creating repository & EMSharer
        -----------------------------
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("postgres");

        EntityManager em = emf.createEntityManager();
        // GET ONE
        Product product = em.find( Product.class, 33L );
        System.out.println( product.getName() );
        System.out.println( product.getCategory().getCategoryName() );
        System.out.println( product.getSupplier().getCompanyName() );
        //em.detach(product);

        // GET ALL
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
        List<Product> list = query.getResultList();
        list.forEach( p -> System.out.println(p.getName()) );

        // UPDATE
        em.getTransaction().begin();
        product.setQttPerUnit("300g"); // l'entité étant attachée, les infos sont apportées à la db au prochain commit
        em.getTransaction().commit();

        // INSERT
        Category cat = new Category();
        cat.setId( (short)18 );
        cat.setCategoryName("Others");
        cat.setDescription("Products with default category");

        em.getTransaction().begin();
//        em.persist( cat );  // si id != des id déjà présent, sinon exception
        em.merge( cat );    // si id != des id déjà présent, sinon update
        em.getTransaction().commit();

        // DELETE
        em.getTransaction().begin();
        cat = em.merge( cat );
        em.remove( cat );
        em.getTransaction().commit();
        emf.close();
        */
    }
}