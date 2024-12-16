package com.project.web.SweetCRUD.service.impl;

import com.project.web.SweetCRUD.dto.SalesDetailDto;
import com.project.web.SweetCRUD.dto.SalesDto;
import com.project.web.SweetCRUD.entity.Product;
import com.project.web.SweetCRUD.entity.Sales;
import com.project.web.SweetCRUD.entity.Users;
import com.project.web.SweetCRUD.repository.ProductRepository;
import com.project.web.SweetCRUD.repository.SalesRepository;
import com.project.web.SweetCRUD.repository.UserRepository;
import com.project.web.SweetCRUD.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    SalesRepository salesRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<SalesDto> getAllSales() throws Exception {
        List<SalesDto> sales= new ArrayList<SalesDto>();
        Iterable<Sales> iterable=salesRepository.findAll();
        iterable.forEach(sale->{
                    SalesDto saleDto = new SalesDto(
                            sale.getIdSale(),
                            sale.getUsers().getEmail(),
                            sale.getProduct().getName(),
                            sale.getSaleDate());
                    sales.add(saleDto);
                }
        );
        return sales;

    }

    @Override
    public boolean addSale(SalesDetailDto salesDetailDto) throws Exception {

            Optional<Users> user=userRepository.findById(salesDetailDto.idUser());
            Optional<Product> product=productRepository.findById(salesDetailDto.id());

            if(user.isPresent() && product.isPresent()){
            Sales sales = new Sales();
            sales.setUsers(user.get());
            sales.setProduct(product.get());
            sales.setCreditCardNumber(salesDetailDto.creditCardNumber());
            sales.setExpirationMonth(salesDetailDto.expirationMonth());
            sales.setExpirationYear(salesDetailDto.expirationYear());
            sales.setCvv(salesDetailDto.cvv());
            sales.setCardholderName(salesDetailDto.cardholderName());
            sales.setSaleDate(new Date());
            salesRepository.save(sales);
            return true;
            }else{
                return false;
            }
    }

}

