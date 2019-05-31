package com.Shopnow.controller;


import com.Shopnow.entity.shopNoweventaddress;
import com.Shopnow.entity.shopNoweventProduct_options;
import com.Shopnow.entity.Products_list_event;
import com.Shopnow.entity.Productsevent;
import com.Shopnow.entity.shopNoweventCategory;
import com.Shopnow.entity.shopNoweventCustomer_list;
import com.Shopnow.entity.shopNoweventOffer;
import com.Shopnow.entity.shopNoweventProduct_att;
import com.Shopnow.entity.shopNoweventProducts_family;
import com.Shopnow.entity.shopNoweventWish_list;
import com.Shopnow.service.shopNowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Collection;

@RestController
@RequestMapping("/shopnow")
public class shopNowController {

    @Autowired
    private shopNowService shopnowService;
    
//------------------------- THIS METHOD FOR  APPLY CRUD OPERATION ON  ADDRESS TABLE-----------------------------------------------------------------------------------------------
    
    @RequestMapping(value="/customer_address/",method = RequestMethod.GET)
    public String getAllCustomer_address() throws SQLException{
        return shopnowService.getAllCustomer_address().toString();
    }
  
    @RequestMapping(value = "/customer_address/{customerId}", method = RequestMethod.GET)
    public String getCustomer_addressById(@PathVariable("customerId") int customerId) throws SQLException, ClassNotFoundException{
        return shopnowService.getCustomer_addressById(customerId).toString();
    }
  
    @RequestMapping(value = "/customer_address_del/", method = RequestMethod.DELETE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteCustomer_addressById(@RequestBody shopNoweventaddress emp) throws ClassNotFoundException, SQLException{
    	return shopnowService.removeCustomer_addressById(emp).toString();
    }
    
    
    //----------------------------------------Insert Customer Address SQL Query--------------------------------------------------------------------------------------------------------------------

    @RequestMapping(value="/customer_address_insert/",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String insertCustomer_address(@RequestBody shopNoweventaddress  emp){
    	return shopnowService.insertCustomer_adress(emp);
    
    }
    
    
   
  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++  
    
  //------------------------------------THIS METHOD FOR  new  Category TABLE-------------------------------------------------------------------------------------------------------
    
    
    @RequestMapping(value="/CategoryNew/",method = RequestMethod.GET)
    public String getAllCategorynew() throws SQLException, ClassNotFoundException{
        return shopnowService.getAllCategorynew().toString();
    }

    @RequestMapping(value = "/CategoryNew/{id}", method = RequestMethod.GET)
    public String getCategorynewById(@PathVariable("id") int id) throws SQLException, ClassNotFoundException{
        return shopnowService.getCategorynewById(id).toString();
    }
    
   //------------------------------ ------------------------------- PRODUCTS_list TABLE--------------------------------------------------------------------------------- 
    
    @RequestMapping(value="/product_list/", method = RequestMethod.GET)
    public String getProducts_list() throws SQLException{
        return shopnowService.getProducts_list().toString();
        
    }
    
    @RequestMapping(value="/product_list/",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getProducts_listById(@RequestBody Products_list_event product_list) throws SQLException, ClassNotFoundException{
    	 return shopnowService.getProducts_listById(product_list);
    
    }
    
  
    
      
//----------------------------- THIS METHOD FOR  APPLY CRUD OPERATION ON  PRODUCTS_Detail2 TABLE---------------------------------------------------------------------------------
  
  
    @RequestMapping(value = "/product_detail/{id}", method = RequestMethod.GET)
    public String getProduct_detailById(@PathVariable("id") int id) throws SQLException, ClassNotFoundException{
        return shopnowService.getProduct_detailById(id).toString();
    }
    
    
   //--------------------------------------------------Customer_list----------------------------------------------------******************************************************** 
    
    @RequestMapping(value="/Customer_list/",method = RequestMethod.GET)
    public String getAllCustomer() throws SQLException, ClassNotFoundException{
        return shopnowService.getAllCustomer();
    }

    @RequestMapping(value = "/Customer_list/{id}", method = RequestMethod.GET)
    public String getCustomerById(@PathVariable("id") int id) throws SQLException, ClassNotFoundException{
        return shopnowService.getCustomerById(id);
    
    }

   
   // -------------------------------------------------           DEAL_DEATAIL TABLE---------------------------------------------------------------------***************************************
    @RequestMapping(value="/Products_Deal/",method = RequestMethod.GET)
    public String getAllDeal_detail() throws SQLException, ClassNotFoundException{
        return shopnowService.getAllDeal_detail();
    }

    @RequestMapping(value = "/Products_Deal/{id}", method = RequestMethod.GET)
    public String getDeal_detailByI(@PathVariable("id") int id) throws SQLException, ClassNotFoundException{
        return shopnowService.getDeal_detailById(id);

    }
    
    
    
  //------------------------------------------------------------------WISH_LIST_VIEW DATA---------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/wish_list_view/{id}", method = RequestMethod.GET)
    public String getwish_listByCust_Id(@PathVariable("id") int id) throws SQLException, ClassNotFoundException{
        return shopnowService.getwish_listByCust_Id(id);
    
    }

    @RequestMapping(value="/wish_list_insert/",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String insert_wish_listToDb(@RequestBody shopNoweventWish_list  wl) throws ClassNotFoundException, SQLException{
    	return shopnowService.insert_wish_listToDb(wl);
    }
    
    @RequestMapping(value="/wish_list_delete/",method = RequestMethod.DELETE)
    public String delete_wish_listToDb(@RequestBody shopNoweventWish_list  wl) throws ClassNotFoundException, SQLException{
    	return shopnowService.delete_wish_listToDb(wl);
    }

    //----------------------------------------------------------    login----------------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/Customer_list_login/", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getadmin_By_emailAnd_psw(@RequestBody shopNoweventCustomer_list  a1) throws SQLException, ClassNotFoundException{
        return shopnowService.getcustomer_By_emailAnd_psw(a1);
    
    }
    
    
    //---------------------------------------------------------change password for customer table--------------------------------------------------------------------------------------------------------
    
    
    @RequestMapping(value="/customer_list_update/",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateCustomer_list_pass(@RequestBody shopNoweventCustomer_list  cust) throws ClassNotFoundException, SQLException{
    	return shopnowService.updateCustomer_list_pass(cust);
    }
    
    
    //------------------------------------insert record for new customer registration-----------------------------------------------------------------
    @RequestMapping(value="/customer_list_insert/",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String insertCustomer_list(@RequestBody shopNoweventCustomer_list  cust) throws ClassNotFoundException, SQLException{
    	return shopnowService.shopNoweventCustomer_list(cust);
    }
    

    
    
    //--------------------------------------------------------homeByCustomerId------------------------------------------------
    @RequestMapping(value = "/Home/{id}", method = RequestMethod.GET)
    public String getHomeByCust_Id(@PathVariable("id") int id) throws SQLException, ClassNotFoundException{
        return shopnowService.getHomeByCust_Id(id);
    
    
    }
    
    @RequestMapping(value = "/Home/", method = RequestMethod.GET)
    public String getHome() throws SQLException, ClassNotFoundException{
        return shopnowService.getHome();
  
    
    }
    
    
    
    
 
    
    
    
    //--------------------------------------------------------filter_api-------------------------------------------------------------

    @RequestMapping(value = "/filter/{id}", method = RequestMethod.GET)
    public String getfilterByCategory_Id(@PathVariable("id") int id) throws SQLException, ClassNotFoundException{
        return shopnowService.getfilterByCategory_Id(id);
    
    
    }
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //----------------------------------------------------------extra services----------------------------------------------------------------------
    //-----------------------------------------------Update Customer Address Data------------------------------------------------------------------------------------------------------------------
    @RequestMapping(value="/customer_address_update/",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCustomer_addressById(@RequestBody shopNoweventaddress emp){
    	shopnowService.updateCustomer_addressById(emp);
    }
    
    
 // -------------------------------------------THIS METHOD FOR  PRODUCT_ATTRIBUTE TABLE--------------------------------------------------------------------------------------------------------------------  
    
    
    @RequestMapping(value = "/product_attribute/", method = RequestMethod.GET)
    public Collection<shopNoweventProduct_att> getAllProduct_att() throws SQLException{
        return shopnowService.getAllProduct_atts();
    }

    @RequestMapping(value = "/product_attribute/{Product_id}", method = RequestMethod.GET)
    public Collection<shopNoweventProduct_att> getProduct_attById(@PathVariable("Product_id") int Product_id) throws SQLException, ClassNotFoundException{
        return shopnowService.getProduct_attById(Product_id);
    }
    
    
    
    //----------------------------------------- THIS METHOD FOR  offer TABLE-----------------------------------------------------------------------------------------------------------

    @RequestMapping( value="/offer/",method = RequestMethod.GET)
    public Collection<shopNoweventOffer> getAllOffer() throws SQLException{
       
    	return shopnowService.getAllOffer();
    }

    @RequestMapping(value = "/offer/{id}",method = RequestMethod.GET)
    public Collection<shopNoweventOffer> getOfferById(@PathVariable("id") int id) throws SQLException, ClassNotFoundException{
        return shopnowService.getOfferById(id);
    }

   
  
    //----------------------------------------------------------------------THIS METHOD FOR  PRODUCTS TABLE-----------------------------------------------------------------------------------------------------
    
    @RequestMapping(value="/product/", method = RequestMethod.GET)
    public Collection<Productsevent> getAllProducts() throws SQLException{
        return shopnowService.getAllProducts();
    }
  
    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public Collection<Productsevent> getProductsById(@PathVariable("id") int id) throws SQLException, ClassNotFoundException{
        return shopnowService.getProductsById(id);
    }
    

    //--------------------------------THIS METHOD FOR  APPLY CRUD OPERATION ON  Category TABLE-----------------------------------------------------------------------------------
    
    @RequestMapping(value="/Category/",method = RequestMethod.GET)
    public Collection<shopNoweventCategory> getAllCategory() throws SQLException, ClassNotFoundException{
        return shopnowService.getAllCategory();
    }

    @RequestMapping(value = "/Category/{id}", method = RequestMethod.GET)
    public Collection<shopNoweventCategory> getCategoryById(@PathVariable("id") int id) throws SQLException, ClassNotFoundException{
        return shopnowService.getCategoryById(id);
    }
    

    //-------------------------------------------------PRODUCTS_FAMILY----------------------------------------------
       @RequestMapping(value="/Products_family/",method = RequestMethod.GET)
       public Collection<shopNoweventProducts_family> getAllProducts_family() throws SQLException, ClassNotFoundException{
           return shopnowService.getAllProducts_family();
       }

       @RequestMapping(value = "/Products_family/{id}", method = RequestMethod.GET)
       public Collection<shopNoweventProducts_family> getProducts_familyById(@PathVariable("id") int id) throws SQLException, ClassNotFoundException{
           return shopnowService.getProducts_familyById(id);

       }
       
     //-------------------------------------------------PRODUCTS_OPTION------------------------------------------------------------------------------------------------------
       @RequestMapping(value="/Products_option/",method = RequestMethod.GET)
       public Collection<shopNoweventProduct_options> getAllProduct_options() throws SQLException, ClassNotFoundException{
           return shopnowService.getAllProduct_options();
       }

       @RequestMapping(value = "/Products_option/{id}", method = RequestMethod.GET)
       public Collection<shopNoweventProduct_options> getProduct_optionsByI(@PathVariable("id") int id) throws SQLException, ClassNotFoundException{
           return shopnowService.getProduct_optionsById(id);

       }
    
    
    
    
}
