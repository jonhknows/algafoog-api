package com.algaworks.algafood.api.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

//	@Autowired
//	private CadastroRestauranteService cadastroRestaurante;
	
	@Autowired
	private RestauranteRepository restaurante;
	
	@GetMapping
	public List<Restaurante> listar(){
		return restaurante.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Restaurante> buscar(@PathVariable Long id) {
		
//		Restaurante restaurante = cadastroRestaurante.buscar(id);
//		
//		if(restaurante != null)		
//			return ResponseEntity.ok(restaurante);
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
//	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante) {
		try {
//			restaurante = cadastroRestaurante.salvar(restaurante);
			return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
			
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Restaurante restaurante){
//		try {
//			Restaurante restauranteAtual = cadastroRestaurante.buscar(id);
//			if(restauranteAtual != null) {
//				BeanUtils.copyProperties(restaurante, restauranteAtual, "id");
//				
//				restauranteAtual = cadastroRestaurante.salvar(restauranteAtual);
//				
//				return ResponseEntity.ok(restauranteAtual);
//			}
//			
//			ResponseEntity.notFound().build();
//			
//		}catch (EntidadeNaoEncontradaException e) {
//			return ResponseEntity.badRequest().body(e.getMessage());
//		}	
		
		try {
//			Restaurante restauranteAtual = cadastroRestaurante.buscar(id);
//			
//			if (restauranteAtual != null) {
//				BeanUtils.copyProperties(restaurante, restauranteAtual, "id");
//				
//				restauranteAtual = cadastroRestaurante.salvar(restauranteAtual);
//				return ResponseEntity.ok(restauranteAtual);
//			}
			
			return ResponseEntity.notFound().build();
		
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Restaurante> remover(@PathVariable Long id) {
		try {
//			cadastroRestaurante.excluir(id);
			return ResponseEntity.noContent().build();
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
	
	
	@GetMapping("/teste")
	private List<Restaurante> find(String nome, BigDecimal taxaInicial, BigDecimal taxaFinal){
//		return restaurante.findCriteria(nome, taxaInicial, taxaFinal);
				
		return restaurante.findComFreteGratis(nome);
		
	}
	
	@GetMapping("/teste-custom")
	private Optional<Restaurante> restaurantePrimeiro(){
		return restaurante.buscaPrimeiro();
	}
	
	
}

